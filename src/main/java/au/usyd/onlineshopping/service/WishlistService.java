package au.usyd.onlineshopping.service;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import au.usyd.onlineshopping.Entity.User;
import au.usyd.onlineshopping.Entity.Wishlist;

public interface WishlistService {
        
	    public Wishlist getWishlistById(long id);
	    
	    public void addWishlist(Wishlist wishlist);
	    
	    public void deleteWishlist(long id);
	    
	    public void moveToCart(Wishlist wishlist);
	    
		public List<Wishlist> getWishlistByUser(User userId);

}
