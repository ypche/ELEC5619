package au.usyd.onlineshopping.dao;

import au.usyd.onlineshopping.Entity.Wishlist;

public interface WishlistDao {
	public Wishlist getWishlistById(long id);
	
    public void addWishlist(Wishlist wishlist);
    
    public void deleteWishlist(long id);
    
    public void moveToCart(Wishlist wishlist);
}
