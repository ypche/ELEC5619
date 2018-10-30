package au.usyd.onlineshopping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import au.usyd.onlineshopping.Entity.User;
import au.usyd.onlineshopping.dao.UserDao;

@Service
@Transactional

//User Service Implements
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
	
	@Override
	public User getUserById(long id) {
		// TODO Auto-generated method stub
		return userDao.getUserById(id);
	}

	@Override
	public long addUser(User user) {
		// TODO Auto-generated method stub
		userDao.addUser(user);
		return user.getId();
	}

	@Override
	public void deleteUser(long id) {
		// TODO Auto-generated method stub
		userDao.deleteUser(id);
	}

	@Override
	public long login(User user) {
		// TODO Auto-generated method stub
		long id = userDao.login(user);
		return id;
	}

	@Override
	public List<User> getOrdinaryUsers() {
		// TODO Auto-generated method stub
		return userDao.getOrdinaryUsers();
	}

}
