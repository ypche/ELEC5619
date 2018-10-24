package au.usyd.onlineshopping.service;

import java.util.List;

import au.usyd.onlineshopping.Entity.Order;
import au.usyd.onlineshopping.Entity.OrderItem;

public interface OrderItemService {

	public List<OrderItem> getOrderItemsByOrder(Order order);
	public void addOrderItem(OrderItem item);
	public void deleteOrderItem(long id);
	public String getBookTitleOfItem(OrderItem item);
	public double getBookPriceOfItem(OrderItem item);
}
