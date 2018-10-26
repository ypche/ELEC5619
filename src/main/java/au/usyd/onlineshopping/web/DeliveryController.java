package au.usyd.onlineshopping.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import au.usyd.onlineshopping.Entity.Book;
import au.usyd.onlineshopping.Entity.Delivery;
import au.usyd.onlineshopping.Entity.OrderItem;
import au.usyd.onlineshopping.Entity.User;
import au.usyd.onlineshopping.service.DeliveryService;
import au.usyd.onlineshopping.service.OrderItemService;
import au.usyd.onlineshopping.service.UserService;

@Controller
@RequestMapping(value="/delivery")
public class DeliveryController {

	protected final Log logger = LogFactory.getLog(getClass());
	
	@Autowired
	public DeliveryService deliveryService;
	@Autowired
	public UserService userService;
	@Autowired
	public OrderItemService itemService;
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public ModelAndView getAllDeliveries(HttpSession session) {
		ModelAndView model = new ModelAndView("delivery");
		if (session.getAttribute("userID") == null) {
			return new ModelAndView("redirect:/user/login");
		}
		
		long userID = (Long) session.getAttribute("userID");
		User currentUser = userService.getUserById(userID);
		if (!currentUser.getRole().equals("admin")) {
			return new ModelAndView("redirect:/book/getBooks");
		}
		
		List<Delivery> deliveries = deliveryService.getAllDeliveries();
		for (Delivery delivery : deliveries) {
			delivery.setBookTitle(delivery.getBook().getTitle());
			delivery.setBookBuyer(delivery.getUser().getName());
		}
		model.addObject("ItemList", deliveries);
		return model;
	}
}