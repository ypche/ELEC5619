package au.usyd.onlineshopping.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import au.usyd.onlineshopping.Entity.Order;
import au.usyd.onlineshopping.Entity.User;
import au.usyd.onlineshopping.service.OrderService;
import au.usyd.onlineshopping.service.UserService;

@Controller
@RequestMapping("/cart")
public class CartController {

	@Autowired
	public OrderService orderService;
	public UserService userService;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView cart(HttpSession session) {
		ModelAndView model = new ModelAndView("cart");
		long userID = (Long) session.getAttribute("userID");
		User currentUser = userService.getUserById(userID);
		Order orderList = orderService.getOrderByUser(currentUser);
		if (orderList == null) {
			orderList = orderService.addOrder(currentUser);
		}
		model.addObject("list", orderList);
		return model;
	}
}
