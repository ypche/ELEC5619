package au.usyd.onlineshopping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import au.usyd.onlineshopping.Entity.Order;
import au.usyd.onlineshopping.Entity.User;
import au.usyd.onlineshopping.dao.OrderDao;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderDao orderDao;
	
	@Override
	public Order getOrderById(long id) {
		// TODO Auto-generated method stub
		return orderDao.getOrderById(id);
	}

	@Override
	public Order getOrderByUser(User user) {
		// TODO Auto-generated method stub
		return orderDao.getOrderByUser(user);
	}

	@Override
	public List<Order> getAllOrders() {
		// TODO Auto-generated method stub
		return orderDao.getAllOrders();
	}

	@Override
	public Order addOrder(User user) {
		// TODO Auto-generated method stub
		Order order = orderDao.addOrder(user);
		return order;
	}

}
