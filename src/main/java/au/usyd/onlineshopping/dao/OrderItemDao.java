package au.usyd.onlineshopping.dao;

import java.util.List;

import au.usyd.onlineshopping.Entity.Order;
import au.usyd.onlineshopping.Entity.OrderItem;

public interface OrderItemDao {

	public List<OrderItem> getInCartOrderItemsByOrder(Order order);
	public OrderItem getOrderItemByID(long id);
	public String getBookTitleOfItem(OrderItem item);
	public double getBookPriceOfItem(OrderItem item);
	public String getBookDescriptionOfItem(OrderItem item);
	public void addOrderItem(OrderItem orderItem);
	public void deleteOrderItem(long id);
	public void addOrderItem(long bookID, Order order);
	public void buyOrderItems(List<OrderItem> items);
	public void deliveryOrderItem(OrderItem item);
	public String getStatusByBookID(long bookID, long userID);
}
