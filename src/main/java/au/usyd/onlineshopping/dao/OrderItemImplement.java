package au.usyd.onlineshopping.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import au.usyd.onlineshopping.Entity.Order;
import au.usyd.onlineshopping.Entity.OrderItem;

public class OrderItemImplement implements OrderItemDao {

	@Autowired
	public SessionFactory sessionFactory;
	
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public List<OrderItem> getOrderItemsByOrder(Order order) {
		// TODO Auto-generated method stub
		/*Criteria criteria = getSession().createCriteria(OrderItem.class);
		criteria.add(Restrictions.eq("order", order));
		List<OrderItem> items = criteria.list();
		return items;*/
		return null;
	}

	@Override
	public void addOrderItem(OrderItem orderItem) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteOrderItem(long id) {
		// TODO Auto-generated method stub

	}

}
