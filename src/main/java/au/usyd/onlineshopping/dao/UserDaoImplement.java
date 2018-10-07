package au.usyd.onlineshopping.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import au.usyd.onlineshopping.Entity.User;

@Repository
public class UserDaoImplement implements UserDao {

	@Autowired
	public SessionFactory sessionFactory;
	
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public User getUserById(long id) {
		// TODO Auto-generated method stub
		User user = (User) getSession().get(User.class, id);
		return user;
	}

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		getSession().save(user);
	}

	@Override
	public void deleteUser(long id) {
		// TODO Auto-generated method stub
		User user = (User) getSession().get(User.class, id);
		getSession().delete(user);
	}

}
