package au.usyd.onlineshopping.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import au.usyd.onlineshopping.Entity.User;

@Repository
public class UserDaoImplement implements UserDao {

	@Autowired
	public SessionFactory sessionFactory;
	
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public User getUserById(long id) {
		// TODO Auto-generated method stub
		User user = (User) getSession().get(User.class, id);
		return user;
	}

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		getSession().save(user);
	}

	@Override
	public void deleteUser(long id) {
		// TODO Auto-generated method stub
		User user = (User) getSession().get(User.class, id);
		getSession().delete(user);
	}

	@Override
	public long login(User user) {
		// TODO Auto-generated method stub
		String name = user.getName();
		String password = user.getPassword();
		Criteria criteria = getSession().createCriteria(User.class);
		criteria.add(Restrictions.eq("name", name));
		criteria.add(Restrictions.eq("password", password));
		List<User> list = criteria.list();
		if (list.size() > 0)
			return list.get(0).getId();
		else
			return -1;
	}

}
