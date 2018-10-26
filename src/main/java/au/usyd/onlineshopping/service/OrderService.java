package au.usyd.onlineshopping.service;

import java.util.List;

import au.usyd.onlineshopping.Entity.Order;
import au.usyd.onlineshopping.Entity.User;

public interface OrderService {

	public List<Order> getAllOrders();
	public Order getOrderById(long id);
<<<<<<< HEAD
	public Order getOrderByUser(long userID);
=======
	public Order getOrderByUser(User user);
>>>>>>> master
	public Order addOrder(User user);
}
