package au.usyd.onlineshopping.dao;

import java.util.Calendar;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import au.usyd.onlineshopping.Entity.Order;
import au.usyd.onlineshopping.Entity.User;

@Repository
public class OrderDaoImplement implements OrderDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public Order getOrderById(long id) {
		// TODO Auto-generated method stub
		Order order = (Order) getSession().get(Order.class, id);
		return order;
	}

	@Override
	public Order getOrderByUser(User user) {
		// TODO Auto-generated method stub
		Criteria criteria = getSession().createCriteria(Order.class);
		criteria.add(Restrictions.eq("status", "active"));
		criteria.add(Restrictions.eq("userID", user));
//		Order order = (Order) getSession().get(Order.class, userID);
		List<Order> list = criteria.list();
		Order order = list.get(0);
		return order;
	}

	@Override
	public List<Order> getAllOrders() {
		// TODO Auto-generated method stub
		Criteria criteria = getSession().createCriteria(Order.class);		
		return (List<Order>)criteria.list();
	}

	@Override
	public Order addOrder(User user) {
		// TODO Auto-generated method stub
		Order order = new Order();
		order.setOrderDate(Calendar.getInstance().getTime());
		order.setStatus("active");
		order.setUserID(user);
		order.setUserName(user.getName());
		getSession().save(order);
		return order;
	}

}
