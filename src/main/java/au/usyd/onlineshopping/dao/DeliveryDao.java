package au.usyd.onlineshopping.dao;

import java.util.List;

import au.usyd.onlineshopping.Entity.Delivery;
import au.usyd.onlineshopping.Entity.OrderItem;
import au.usyd.onlineshopping.Entity.User;

public interface DeliveryDao {

	public List<Delivery> getAllDeliveries();
	public Delivery getDeliveryById(long id);
	public void addDeliveriesFromOrderItems(List<OrderItem> items, User user);
	public void generatePurchaseCode(long id);
	public List<Delivery> getAllDeliveriesWithBoughtItems();
	public boolean checkCode(String code, long bid, long uid);
}
