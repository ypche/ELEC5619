package au.usyd.onlineshopping.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import au.usyd.onlineshopping.Entity.Book;
import au.usyd.onlineshopping.Entity.Order;
import au.usyd.onlineshopping.Entity.OrderItem;
import au.usyd.onlineshopping.Entity.User;

@Repository
public class OrderItemDaoImplement implements OrderItemDao {

	protected final Log logger = LogFactory.getLog(getClass());
	
	@Autowired
	public SessionFactory sessionFactory;
	
	@Autowired
	public BookDao bookDao;
	
	@Autowired
	public UserDao userDao;
	
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public List<OrderItem> getInCartOrderItemsByOrder(Order order) {
		// TODO Auto-generated method stub
		Criteria criteria = getSession().createCriteria(OrderItem.class);
		criteria.add(Restrictions.eq("order", order));
		criteria.add(Restrictions.eq("status", "InCart"));
		List<OrderItem> items = criteria.list();
		return items;
		/*return null;*/
	}

	@Override
	public void addOrderItem(OrderItem orderItem) {
		// TODO Auto-generated method stub
		getSession().save(orderItem);
	}

	@Override
	public void deleteOrderItem(long id) {
		// TODO Auto-generated method stub
		OrderItem item = (OrderItem) getSession().get(OrderItem.class, id);
		Order order = item.getOrder();
		Book book = item.getBook();
		
		double total = order.getTotal();
		total -= book.getPrice();
		total = Double.parseDouble(String.format("%.2f", total));
		order.setTotal(total);
		getSession().merge(order);
		
		getSession().delete(item);
	}

	@Override
	public String getBookTitleOfItem(OrderItem item) {
		// TODO Auto-generated method stub
		return item.getBook().getTitle();
	}

	@Override
	public double getBookPriceOfItem(OrderItem item) {
		// TODO Auto-generated method stub
		return item.getBook().getPrice();
	}

	@Override
	public void addOrderItem(long bookID, Order order) {
		// TODO Auto-generated method stub
		Book book = bookDao.getBookById(bookID);
		OrderItem item = new OrderItem();
		item.setBook(book);
		item.setOrder(order);
		item.setStatus("InCart");
		getSession().save(item);
		
		double total = order.getTotal();
		total += book.getPrice();
		total = Double.parseDouble(String.format("%.2f", total));
		order.setTotal(total);
		getSession().merge(order);
	}

	@Override
	public OrderItem getOrderItemByID(long id) {
		// TODO Auto-generated method stub
		OrderItem item = (OrderItem) getSession().get(OrderItem.class, id);
		return item;
	}

	@Override
	public void buyOrderItems(List<OrderItem> items) {
		// TODO Auto-generated method stub
		if (items.size() == 0)
			return;
		
		for (OrderItem item : items) {
			item.setStatus("Bought");
			getSession().merge(item);
			
			Order order = item.getOrder();
			double total = order.getTotal();
			Book book = item.getBook();
			total -= book.getPrice();
			total = Double.parseDouble(String.format("%.2f", total));
			order.setTotal(total);
			getSession().merge(order);
		}
	}

	@Override
	public void deliveryOrderItem(OrderItem item) {
		// TODO Auto-generated method stub
		item.setStatus("Delivered");
		getSession().merge(item);
	}

	@Override
	public String getBookDescriptionOfItem(OrderItem item) {
		// TODO Auto-generated method stub
		return item.getBook().getDescription();
	}

	@Override
	public String getStatusByBookID(long bookID, long userID) {
		// TODO Auto-generated method stub
		String status = "";
		Book book = bookDao.getBookById(bookID);
		Criteria criteria = getSession().createCriteria(OrderItem.class);
		criteria.add(Restrictions.eq("book", book));
		List<OrderItem> items = criteria.list();
		for (OrderItem item : items) {
			if (item.getOrder().getUserID().getId() == userID) {
				status = item.getStatus();
				break;
			}
		}
		return status;
	}

}
