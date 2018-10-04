package au.usyd.onlineshopping.dao;

import java.util.List;

import au.usyd.onlineshopping.Entity.Order;
import au.usyd.onlineshopping.Entity.OrderItem;

public interface OrderItemDao {

	public List<OrderItem> getOrderItemsByOrder(Order order);
	public void addOrderItem(OrderItem orderItem);
	public void deleteOrderItem(long id);
}
