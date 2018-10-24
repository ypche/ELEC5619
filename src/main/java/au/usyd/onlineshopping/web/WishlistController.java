package au.usyd.onlineshopping.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import au.usyd.onlineshopping.service.WishlistService;

@Controller
@RequestMapping(value = "/wishlist/**")
public class WishlistController {
	
	@Resource(name = "wishlistService")
	private WishlistService wishlistService;
	
    @RequestMapping(value ="/delete/{id}",method = RequestMethod.GET)
    public String deleteWishlist(@PathVariable("id")Long id) {
    	this.wishlistService.deleteWishlist(id);
       	return "redirect:/wishlist.htm";
    }
	

}
