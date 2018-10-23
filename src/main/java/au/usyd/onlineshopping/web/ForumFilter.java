package au.usyd.onlineshopping.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import au.usyd.onlineshopping.Entity.User;
import static au.usyd.onlineshopping.cons.CommonConstant.*;


public class ForumFilter implements Filter {
	
	private static final String FILTERED_REQUEST = "@@session_context_filtered_request";
	
	//access url without login in
	private static final String[] INHERENT_ESCAPE_URIS = {
			"/index.jsp", "/index.html", "/board/listBoardTopics-",
			"/board/listTopicPosts-"
	};
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
	//execute the function of filter
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		//to ensure filter just once
		if (request != null && request.getAttribute(FILTERED_REQUEST) != null) {
			chain.doFilter(request, response);

		}else {
			//prevent filter many times
			request.setAttribute(FILTERED_REQUEST, Boolean.TRUE);
			HttpServletRequest httpRequest = (HttpServletRequest) request;
			User userContext = getSessionUser(httpRequest);
			
			//for url which needs login in
			if (userContext == null && !isURILogin(httpRequest.getRequestURI(), httpRequest)) {
				String toUrl = httpRequest.getRequestURL().toString();
				if (!StringUtils.isEmpty(httpRequest.getQueryString())) {
					toUrl += "?" + httpRequest.getQueryString();
				}
				
				//put the url request into session
				httpRequest.getSession().setAttribute(LOGIN_TO_URL, toUrl);
				
				//redirect to login in page
				request.getRequestDispatcher("/login.jsp").forward(request, response);
				
				return;
			}
			chain.doFilter(request, response);
		}
	}
	
	//judge which url needs login in 
	
	private boolean isURILogin(String requestURI, HttpServletRequest request) {

		if (request.getContextPath().equalsIgnoreCase(requestURI)
				|| (request.getContextPath() + "/").equalsIgnoreCase(requestURI))
			return true;
		for (String uri : INHERENT_ESCAPE_URIS) {
			if (requestURI != null && requestURI.indexOf(uri) >=0 ) {
				return true;
			}
		}
		return false;
	}

	private User getSessionUser(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return (User) request.getSession().getAttribute(USER_CONTEXT);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	
}