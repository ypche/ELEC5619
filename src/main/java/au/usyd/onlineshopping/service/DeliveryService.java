package au.usyd.onlineshopping.service;

import java.util.List;

import au.usyd.onlineshopping.Entity.Delivery;
import au.usyd.onlineshopping.Entity.OrderItem;
import au.usyd.onlineshopping.Entity.User;

public interface DeliveryService {

	public List<Delivery> getAllDeliveries();
	public Delivery getDeliveryById(long id);
	public void addDeliveriesFromOrderItems(List<OrderItem> items, User user);
	public void generatePurchaseCode(long id);
	public List<Delivery> getAllDeliveriesWithBoughtItems();
}
