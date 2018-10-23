package au.usyd.onlineshopping.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.util.Assert;

import au.usyd.onlineshopping.Entity.User;
import au.usyd.onlineshopping.cons.CommonConstant;

public class BaseController {
	
	protected static final String ERROR_MSG_KEY = "errorMsg";
	
	//get the User objects in session
	protected User getSessionUser(HttpServletRequest request) {
		return (User) request.getSession().getAttribute(CommonConstant.USER_CONTEXT);
		
	}
	
	
	//save user objects to session
	public void setSessionUser(HttpServletRequest request, User user) {
		//return (User) request.getSession()	.getAttribute(CommonConstant.USER_CONTEXT);
		request.getSession().setAttribute(CommonConstant.USER_CONTEXT, user);
	}
	
	//get the basic url path
	public final String getAppbaseUrl(HttpServletRequest request, String url) {
		
		Assert.hasLength(url, "url cannot be empty");
		Assert.isTrue(url.startsWith("/"), "should start with /");
		return request.getContextPath() + url;
		
	}
}
