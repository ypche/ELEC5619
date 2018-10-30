package au.usyd.onlineshopping.service;

import java.util.List;

import au.usyd.onlineshopping.Entity.User;

// UserServuce
public interface UserService {

	public User getUserById(long id);
	public long addUser(User user);
	public void deleteUser(long id);
	public long login(User user);
	public List<User> getOrdinaryUsers();
}
