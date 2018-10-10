package au.usyd.onlineshopping.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import au.usyd.onlineshopping.Entity.User;
import au.usyd.onlineshopping.service.UserService;

@Controller
@RequestMapping("/user")
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
	public String saveUser(@ModelAttribute User user) {
		userService.addUser(user);
		return "redirect:/book/getAllBooks";
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
		if (id > 0)
		{
			session.setAttribute("userID", id);
			return "redirect:/book/getAllBooks";
		}
		else
			return "redirect:/user/login";
	}
}
