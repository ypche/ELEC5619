package au.usyd.onlineshopping.dao;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
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

	@Override
	public void generatePurchaseCode(long id) {
		// TODO Auto-generated method stub
		Delivery delivery = getDeliveryById(id);
		delivery.setPurchaseCode(generateRandomString(15));
		getSession().merge(delivery);
	}

	public String generateRandomString(int length) {
		String ALPHABET = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_!@#$%^&*[]{}?<>";
		SecureRandom RANDOM = new SecureRandom();
		StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; ++i) {
            sb.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
        }
        return sb.toString();
	}

	@Override
	public List<Delivery> getAllDeliveriesWithBoughtItems() {
		// TODO Auto-generated method stub
		List<Delivery> deliveries = getAllDeliveries();
		List<Delivery> removeOnes = new ArrayList<Delivery>();
		for (Delivery delivery : deliveries) {
			if (!delivery.getItem().getStatus().equals("Bought")) {
				removeOnes.add(delivery);
			}
			else {
				delivery.setBookTitle(delivery.getBook().getTitle());
				delivery.setBookBuyer(delivery.getUser().getName());
			}
		}
		
		for (Delivery r : removeOnes) {
			deliveries.remove(r);
		}
		return deliveries;
	}
}
