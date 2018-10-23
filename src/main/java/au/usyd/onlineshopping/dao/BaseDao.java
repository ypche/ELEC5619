package au.usyd.onlineshopping.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.hibernate.Query;
import org.hibernate.Session;

//import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.SessionFactoryUtils;
import org.springframework.util.Assert;

public class BaseDao<T>{
	private Class<T> entityClass;
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	//Gets the generic class determined by the subclass by reflection
	public BaseDao() {
		Type genType = getClass().getGenericSuperclass();
		Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
		entityClass = (Class) params [0];
	}
	
	//load PO instance according to ID
	public T load(Serializable id) {
		return (T) getHibernateTemplate().load(entityClass, id);
				
	}
	//obtain PO instance according to ID
	public T get(Serializable id) {
		return (T) getHibernateTemplate().get(entityClass, id);
	}
	
	//obtain whole objects of PO
	public List<T> loadAll(){
		return getHibernateTemplate().loadAll(entityClass);
	}
	
	//store PO
	public void save(T entity) {
		getHibernateTemplate().save(entity);
	}
	
	//delete PO
	public void remove(T entity) {
		getHibernateTemplate().delete(entity);
	}
	
	//update PO
	public void update(T entity) {
		getHibernateTemplate().update(entity);
	}
	
	//execute hql search
	public List find(String hql) {
		return this.getHibernateTemplate().find(hql);
	}
	
	public List find(String hql, Object... params) {
		return this.getHibernateTemplate().find(hql, params);
		 
	}
	
	// initialize
	public void initialize(Object entity) {
		this.getHibernateTemplate().initialize(entity);
	}
	
	// search in different page
	public Page pagedQuery(String hql, int pageNo, int pageSize, Object... values) {
		Assert.hasText(hql);
		Assert.isTrue(pageNo >= 1, "pageNo should start from 1");
		//count search
		String countQueryString = " select count (*) " + removeSelect(removeOrders(hql));
		List countlist = getHibernateTemplate().find(countQueryString, values);
		long totalCount = (Long) countlist.get(0);
		
		if (totalCount < 1)
			return new Page();
		//actual search page
		int startIndex = Page.getStartOfPage(pageNo, pageSize);
		Query query = createQuery(hql, values);
		List list = query.setFirstResult(startIndex).setMaxResults(pageSize).list();
		
		return new Page(startIndex, totalCount, pageSize, list);
	}
	
	public Query createQuery(String hql, Object... values) {
		Assert.hasText(hql);
		Query query = getSession().createQuery(hql);
		for(int i = 0; i < values.length; i++) {
			query.setParameter(i, values[i]);
		}
		return query;
	}
	
	private static String removeSelect(String hql) {
		Assert.hasText(hql);
		int beginPos = hql.toLowerCase().indexOf("from");
		Assert.isTrue(beginPos != -1, " hql : " + hql + " must has a keyword 'from'");
		return hql.substring(beginPos);
	}
	
	private static String removeOrders(String hql) {
		Assert.hasText(hql);
		Pattern p = Pattern.compile("order\\s*by[\\w|\\W|\\s|\\S]*", Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(hql);
		StringBuffer sb = new StringBuffer();
		while (m.find()) {
			m.appendReplacement(sb, "");
		}
		m.appendTail(sb);
		return sb.toString();
	}
	
	public HibernateTemplate getHibernateTemplate()	{
		return hibernateTemplate;
	}
	
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	public Session getSession() {
		return SessionFactoryUtils.getSession(hibernateTemplate.getSessionFactory(), true);
	}
}