package au.usyd.onlineshopping.service;

import au.usyd.onlineshopping.Entity.Wishlist;

public interface WishlistService {
        
	    public Wishlist getWishlistById(long id);
	    
	    public void addWishlist(Wishlist wishlist);
	    
	    public void deleteWishlist(long id);
	    
	    public void moveToCart(Wishlist wishlist);

}
