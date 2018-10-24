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

@Repository
public class OrderItemDaoImplement implements OrderItemDao {

	protected final Log logger = LogFactory.getLog(getClass());
	
	@Autowired
	public SessionFactory sessionFactory;
	
	@Autowired
	public BookDao bookDao;
	
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public List<OrderItem> getOrderItemsByOrder(Order order) {
		// TODO Auto-generated method stub
		Criteria criteria = getSession().createCriteria(OrderItem.class);
		criteria.add(Restrictions.eq("order", order));
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
		getSession().save(item);
	}

}
