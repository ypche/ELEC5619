package au.usyd.onlineshopping.service;

import au.usyd.onlineshopping.Entity.User;

public interface UserService {

	public User getUserById(long id);
	public void addUser(User user);
	public void deleteUser(long id);
	public long login(User user);
}
