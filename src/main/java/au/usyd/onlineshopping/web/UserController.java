package au.usyd.onlineshopping.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import au.usyd.onlineshopping.Entity.Delivery;
import au.usyd.onlineshopping.Entity.User;
import au.usyd.onlineshopping.service.UserService;

@Controller
@RequestMapping("/user")

// UserController
public class UserController {

	@Autowired
	UserService userService;
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public ModelAndView register() {
		ModelAndView model = new ModelAndView("register");
		User user = new User();
		model.addObject("userForm", user);
		return model;
	}
	
	@RequestMapping(value="/saveUser", method=RequestMethod.POST)
	public String saveUser(@ModelAttribute User user, HttpSession session) {
		long id = userService.addUser(user);
		User currentUser = userService.getUserById(id);
		if (id > 0)
		{
			session.setAttribute("userID", id);
			session.setAttribute("role", currentUser.getRole());
			return "redirect:/book/getBooks";
		}
		return "redirect:/user/register";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView model = new ModelAndView("login");
		User user = new User();
		model.addObject("userForm", user);
		return model;
	}
	
	@RequestMapping(value="/loginUser", method=RequestMethod.POST)
	public String loginUser(@ModelAttribute User user, HttpSession session) {
		long id = userService.login(user);
		User currentUser = userService.getUserById(id);
		if (id > 0)
		{
			session.setAttribute("userID", id);
			session.setAttribute("role", currentUser.getRole());
			return "redirect:/book/getBooks";
		}
		else
			return "redirect:/user/login";
	}
	
	@RequestMapping(value="/logout")
	public String logout(HttpSession session) {
		if (session.getAttribute("userID") != null) {
			session.setAttribute("role", null);
			session.invalidate();
		}
		
		return "redirect:/book/getBooks";
	}
	
	@RequestMapping(value="/manage")
	public ModelAndView manageUser(HttpSession session) {
		ModelAndView model = new ModelAndView("manageUser");
		if (session.getAttribute("userID") == null) {
			return new ModelAndView("redirect:/user/login");
		}
		
		long userID = (Long) session.getAttribute("userID");
		User currentUser = userService.getUserById(userID);
		if (!currentUser.getRole().equals("admin")) {
			return new ModelAndView("redirect:/book/getBooks");
		}
		
		List<User> users = userService.getOrdinaryUsers();
		model.addObject("ItemList", users);
		model.addObject("username", currentUser.getName());
		return model;
	}
	
	@RequestMapping(value="/delete/{uids}")
	public String deleteUser(@PathVariable("uids") String uids) {
		String[] uidList = uids.split(",");
		for (String s : uidList) {
			long uid = Long.parseLong(s);
			userService.deleteUser(uid);
		}
		return "redirect:/user/manage";
	}
}
