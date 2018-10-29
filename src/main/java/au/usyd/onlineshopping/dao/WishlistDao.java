package au.usyd.onlineshopping.dao;

import java.util.List;

import au.usyd.onlineshopping.Entity.User;
import au.usyd.onlineshopping.Entity.Wishlist;

public interface WishlistDao {
	public Wishlist getWishlistById(long id);
	
	public List<Wishlist> getWishlistByUser(User userId);
	
    public void addWishlist(Wishlist wishlist);
    
    public void deleteWishlist(long id);
    
    public void moveToCart(Wishlist wishlist);
}
