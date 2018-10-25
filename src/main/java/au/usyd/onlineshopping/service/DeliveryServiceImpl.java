package au.usyd.onlineshopping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import au.usyd.onlineshopping.Entity.Delivery;
import au.usyd.onlineshopping.Entity.OrderItem;
import au.usyd.onlineshopping.Entity.User;
import au.usyd.onlineshopping.dao.DeliveryDao;

@Service
@Transactional
public class DeliveryServiceImpl implements DeliveryService {

	@Autowired
	DeliveryDao deliveryDao;

	@Override
	public List<Delivery> getAllDeliveries() {
		// TODO Auto-generated method stub
		return deliveryDao.getAllDeliveries();
	}

	@Override
	public Delivery getDeliveryById(long id) {
		// TODO Auto-generated method stub
		return deliveryDao.getDeliveryById(id);
	}

	@Override
	public void addDeliveriesFromOrderItems(List<OrderItem> items, User user) {
		// TODO Auto-generated method stub
		deliveryDao.addDeliveriesFromOrderItems(items, user);
	}

}
