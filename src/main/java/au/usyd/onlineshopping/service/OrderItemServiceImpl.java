package au.usyd.onlineshopping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import au.usyd.onlineshopping.Entity.Order;
import au.usyd.onlineshopping.Entity.OrderItem;
import au.usyd.onlineshopping.dao.OrderItemDao;

@Service
@Transactional
public class OrderItemServiceImpl implements OrderItemService {
	
	@Autowired
	OrderItemDao itemDao;

	@Override
	public List<OrderItem> getOrderItemsByOrder(Order order) {
		// TODO Auto-generated method stub
		return itemDao.getOrderItemsByOrder(order);
	}

	@Override
	public void addOrderItem(OrderItem item) {
		// TODO Auto-generated method stub
		itemDao.addOrderItem(item);
	}

	@Override
	public void deleteOrderItem(long id) {
		// TODO Auto-generated method stub
		itemDao.deleteOrderItem(id);
	}

	@Override
	public String getBookTitleOfItem(OrderItem item) {
		// TODO Auto-generated method stub
		return itemDao.getBookTitleOfItem(item);
	}

	@Override
	public double getBookPriceOfItem(OrderItem item) {
		// TODO Auto-generated method stub
		return itemDao.getBookPriceOfItem(item);
	}

	@Override
	public void addOrderItem(long bookID, Order order) {
		// TODO Auto-generated method stub
		itemDao.addOrderItem(bookID, order);
	}

	@Override
	public OrderItem getOrderItemByID(long id) {
		// TODO Auto-generated method stub
		return itemDao.getOrderItemByID(id);
	}

}
