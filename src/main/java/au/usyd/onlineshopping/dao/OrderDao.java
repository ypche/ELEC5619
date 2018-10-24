package au.usyd.onlineshopping.dao;

import java.util.List;

import au.usyd.onlineshopping.Entity.Order;
import au.usyd.onlineshopping.Entity.User;

public interface OrderDao {

	public List<Order> getAllOrders();
	public Order getOrderById(long id);
	public Order getOrderByUser(long userID);
	public Order addOrder(User user);
}
