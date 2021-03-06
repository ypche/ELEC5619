package au.usyd.onlineshopping.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import au.usyd.onlineshopping.Entity.Book;
import au.usyd.onlineshopping.Entity.Order;
import au.usyd.onlineshopping.Entity.OrderItem;
import au.usyd.onlineshopping.Entity.User;
import au.usyd.onlineshopping.service.DeliveryService;
import au.usyd.onlineshopping.service.OrderItemService;
import au.usyd.onlineshopping.service.OrderService;
import au.usyd.onlineshopping.service.UserService;

@Controller
@RequestMapping("/cart")
public class CartController {

	protected final Log logger = LogFactory.getLog(getClass());
	
	@Autowired
	public OrderService orderService;
	@Autowired
	public UserService userService;
	@Autowired
	public OrderItemService itemService;
	@Autowired
	public DeliveryService deliveryService;
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public ModelAndView cart(HttpSession session) {
		ModelAndView model = new ModelAndView("cart");
		if (session.getAttribute("userID") == null) {
			model = new ModelAndView("login");
			User user = new User();
			model.addObject("userForm", user);
			return model;
		}
		long userID = (Long) session.getAttribute("userID");
		User currentUser = userService.getUserById(userID);
		Order order = orderService.getOrderByUser(currentUser);
		if (order == null) {
			order = orderService.addOrder(currentUser);
		}
		order.setUserName(currentUser.getName());
		
		model.addObject("TotalPrice", order.getTotal());
		
		List<OrderItem> itemList = itemService.getInCartOrderItemsByOrder(order);
		for (OrderItem item : itemList) {
			item.setBookTitle(itemService.getBookTitleOfItem(item));
			item.setBookPrice(itemService.getBookPriceOfItem(item));
		}
		model.addObject("ItemList", itemList);
		model.addObject("username", currentUser.getName());
		return model;
	}
	
	@RequestMapping(value="/delete/{id}")
	public String deleteOrderItem(@PathVariable("id") long id) {
		itemService.deleteOrderItem(id);
		return "redirect:/cart";
	}
	
	@RequestMapping(value="/addItem/{bid}")
	public String addOrderItem(@PathVariable("bid") long bid, HttpSession session) {
		if (session.getAttribute("userID") == null) {
			return "redirect:/user/login";
		}
		long userID = (Long) session.getAttribute("userID");
		User currentUser = userService.getUserById(userID);
		Order order = orderService.getOrderByUser(currentUser);
		if (order == null) {
			order = orderService.addOrder(currentUser);
		}
		order.setUserName(currentUser.getName());
		itemService.addOrderItem(bid, order);
		
		return "redirect:/book/getBooks";
	}
	
	@RequestMapping(value="/purchase/{items}", method=RequestMethod.GET)
	public ModelAndView purchase(@PathVariable("items") String itemsID, HttpSession session) {
		ModelAndView model = new ModelAndView("purchase");
		if (session.getAttribute("userID") == null) {
			model = new ModelAndView("login");
			User user = new User();
			model.addObject("userForm", user);
			return model;
		}
		long userID = (Long) session.getAttribute("userID");
		User currentUser = userService.getUserById(userID);
		double totalPrice = 0;
		List<OrderItem> items = new ArrayList<OrderItem>();
		String[] ids = itemsID.split(",");
		for (String sitemID : ids) {
			long itemID = Long.parseLong(sitemID);
			OrderItem item = itemService.getOrderItemByID(itemID);
			item.setBookTitle(itemService.getBookTitleOfItem(item));
			item.setBookPrice(itemService.getBookPriceOfItem(item));
			item.setBookDescription(itemService.getBookDescriptionOfItem(item));
			items.add(item);
			totalPrice += itemService.getBookPriceOfItem(item);
		}
		model.addObject("ItemsDetail", items);
		model.addObject("username", currentUser.getName());
		model.addObject("totalPrice", totalPrice);
		return model;
	}
	
	@RequestMapping(value="/confirm/{items}")
	public String confirm(@PathVariable("items") String itemsID, HttpSession session) {
		if (session.getAttribute("userID") == null) {
			return "redirect:/user/login";
		}
		long userID = (Long) session.getAttribute("userID");
		User currentUser = userService.getUserById(userID);
		List<OrderItem> items = new ArrayList<OrderItem>();
		String[] ids = itemsID.split(",");
		for (String sitemID : ids) {
			long itemID = Long.parseLong(sitemID);
			OrderItem item = itemService.getOrderItemByID(itemID);
			item.setBookTitle(itemService.getBookTitleOfItem(item));
			item.setBookPrice(itemService.getBookPriceOfItem(item));
			item.setBookDescription(itemService.getBookDescriptionOfItem(item));
			items.add(item);
		}
		deliveryService.addDeliveriesFromOrderItems(items, currentUser);
		itemService.buyOrderItems(items);
		return "redirect:/cart";
	}
}
