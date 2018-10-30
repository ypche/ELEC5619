package au.usyd.onlineshopping.dao;

import java.util.List;

import au.usyd.onlineshopping.Entity.User;
// UserDao add user
public interface UserDao {

	public User getUserById(long id);
	public List<User> getOrdinaryUsers();
	public void addUser(User user);
	public void deleteUser(long id);
	public long login(User user);
}
