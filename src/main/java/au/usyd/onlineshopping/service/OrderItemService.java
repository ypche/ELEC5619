package au.usyd.onlineshopping.service;

import java.util.List;

import au.usyd.onlineshopping.Entity.Order;
import au.usyd.onlineshopping.Entity.OrderItem;

public interface OrderItemService {

<<<<<<< HEAD
	public List<OrderItem> getOrderItemsByOrder(Order order);
=======
	public List<OrderItem> getInCartOrderItemsByOrder(Order order);
>>>>>>> master
	public void addOrderItem(OrderItem item);
	public void deleteOrderItem(long id);
	public String getBookTitleOfItem(OrderItem item);
	public double getBookPriceOfItem(OrderItem item);
<<<<<<< HEAD
=======
	public void addOrderItem(long bookID, Order order);
	public OrderItem getOrderItemByID(long id);
	public void buyOrderItems(List<OrderItem> items);
>>>>>>> master
}
