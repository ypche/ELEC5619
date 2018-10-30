package au.usyd.onlineshopping.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import au.usyd.onlineshopping.Entity.Book;
import au.usyd.onlineshopping.Entity.Delivery;
import au.usyd.onlineshopping.Entity.OrderItem;
import au.usyd.onlineshopping.Entity.User;
import au.usyd.onlineshopping.service.BookService;
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
	@Autowired
	public BookService bookService;
	
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
		
		List<Delivery> deliveries = deliveryService.getAllDeliveriesWithBoughtItems();
		model.addObject("ItemList", deliveries);
		model.addObject("username", currentUser.getName());
		return model;
	}
	
	@RequestMapping(value="/sendCode/{deliveriesID}")
	public String generatePurchaseCode(@PathVariable("deliveriesID") String deliveriesID, HttpSession session) {
		String[] dIDList = deliveriesID.split(",");
		for (String deliveryID : dIDList) {
			deliveryService.generatePurchaseCode(Long.parseLong(deliveryID));
			Delivery delivery = deliveryService.getDeliveryById(Long.parseLong(deliveryID));
			itemService.deliveryOrderItem(delivery.getItem());
		}
		return "redirect:/delivery";
	}
	
	@RequestMapping(value="/download/{download}")
	public String downloadBook(@PathVariable("download") String download, HttpSession session) {
		String[] dList = download.split(",");
		long bid = Long.parseLong(dList[0]);
		String code = dList[1];
		
		if (session.getAttribute("userID") == null) {
			return "redirect:/user/login";
		}
		
		long userID = (Long) session.getAttribute("userID");
		if (deliveryService.checkCode(code, bid, userID)) {
			Book book = bookService.getBookById(bid);
			return "redirect:" + book.getBookpath();
		}
		return "redirect:/book/getBooks";
	}
}
