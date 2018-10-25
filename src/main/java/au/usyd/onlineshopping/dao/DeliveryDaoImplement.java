package au.usyd.onlineshopping.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import au.usyd.onlineshopping.Entity.Delivery;
import au.usyd.onlineshopping.Entity.OrderItem;
import au.usyd.onlineshopping.Entity.User;

@Repository
public class DeliveryDaoImplement implements DeliveryDao {

	@Autowired
	public SessionFactory sessionFactory;
	
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public List<Delivery> getAllDeliveries() {
		// TODO Auto-generated method stub
		Criteria criteria = getSession().createCriteria(Delivery.class);
		return (List<Delivery>)criteria.list();
	}

	@Override
	public Delivery getDeliveryById(long id) {
		// TODO Auto-generated method stub
		Delivery delivery = (Delivery) getSession().get(Delivery.class, id);
		return delivery;
	}

	@Override
	public void addDeliveriesFromOrderItems(List<OrderItem> items, User user) {
		// TODO Auto-generated method stub
		if (items.size() == 0)
			return;
		
		for (OrderItem item : items) {
			Delivery delivery = new Delivery();
			delivery.setItem(item);
			delivery.setBook(item.getBook());
			delivery.setUser(user);
			getSession().save(delivery);
		}
	}

}
