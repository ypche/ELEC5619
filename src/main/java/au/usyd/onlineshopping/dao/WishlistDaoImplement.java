package au.usyd.onlineshopping.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import au.usyd.onlineshopping.Entity.User;
import au.usyd.onlineshopping.Entity.Wishlist;
@Transactional
public class WishlistDaoImplement implements WishlistDao{
    
	private SessionFactory sessionfactory;
	
	@Autowired
	public void setSessionFactory(SessionFactory sf) {
		this.sessionfactory = sf;
	}
	@Override
	public void addWishlist(Wishlist wishlist) {
		this.sessionfactory.getCurrentSession().save(wishlist);
	}

	@Override
	public void deleteWishlist(long id) {
		Session currentSession = this.sessionfactory.getCurrentSession();
		Wishlist wishlist = (Wishlist)currentSession.get(Wishlist.class, id);
		currentSession.delete(wishlist);
	}

	@Override
	public void moveToCart(Wishlist wishlist) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Wishlist getWishlistById(long id) {
		Session currentSession = this.sessionfactory.getCurrentSession();
		Wishlist wishlist = (Wishlist) currentSession.get(Wishlist.class, id);
		return wishlist;	
	}
	@Override
	public List<Wishlist> getWishlistByUser(User userId) {
		Criteria criteria = sessionfactory.getCurrentSession().createCriteria(Wishlist.class);
		criteria.add(Restrictions.eq("userId", userId));
		List<Wishlist> wishlists = criteria.list();
		return wishlists;
	}
	
	
	

}
