package au.usyd.onlineshopping.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import au.usyd.onlineshopping.Entity.Order;
import au.usyd.onlineshopping.service.OrderService;

@Controller
@RequestMapping("/cart")
public class CartController {

	@Autowired
	public OrderService orderService;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView cart() {
		ModelAndView model = new ModelAndView("cart");
		List<Order> orderList = orderService.getAllOrders();
		model.addObject("list", orderList);
		return model;
	}
}
