package au.usyd.onlineshopping.service;

import java.util.List;

import au.usyd.onlineshopping.Entity.Order;
import au.usyd.onlineshopping.Entity.OrderItem;

public interface OrderItemService {

	public List<OrderItem> getInCartOrderItemsByOrder(Order order);
	public void addOrderItem(OrderItem item);
	public void deleteOrderItem(long id);
	public String getBookTitleOfItem(OrderItem item);
	public double getBookPriceOfItem(OrderItem item);
	public String getBookDescriptionOfItem(OrderItem item);
	public void addOrderItem(long bookID, Order order);
	public OrderItem getOrderItemByID(long id);
	public void buyOrderItems(List<OrderItem> items);
	public void deliveryOrderItem(OrderItem item);
}
