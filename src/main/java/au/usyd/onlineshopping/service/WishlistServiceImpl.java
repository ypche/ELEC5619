package au.usyd.onlineshopping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import au.usyd.onlineshopping.Entity.User;
import au.usyd.onlineshopping.Entity.Wishlist;
import au.usyd.onlineshopping.dao.WishlistDao;

@Service
@Transactional

public class WishlistServiceImpl implements WishlistService{
    
	@Autowired
	WishlistDao wishlistDao;
	
	@Override
	public void addWishlist(Wishlist wishlist) {
		wishlistDao.addWishlist(wishlist);
	}

	@Override
	public void deleteWishlist(long id) {
		wishlistDao.deleteWishlist(id);	
	}

	@Override
	public void moveToCart(Wishlist wishlist) {
		wishlistDao.moveToCart(wishlist);	
	}

	@Override
	public Wishlist getWishlistById(long id) {

		return wishlistDao.getWishlistById(id);
	}

	@Override
	public List<Wishlist> getWishlistByUser(User userId) {

		return wishlistDao.getWishlistByUser(userId);
	}

}
