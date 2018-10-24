package au.usyd.onlineshopping.dao;

import au.usyd.onlineshopping.Entity.User;

public interface UserDao {

	public User getUserById(long id);
	
	public void addUser(User user);
	public void deleteUser(long id);
	public long login(User user);
}
