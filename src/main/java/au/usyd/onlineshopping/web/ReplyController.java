package au.usyd.onlineshopping.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import au.usyd.onlineshopping.Entity.CommentPost;
import au.usyd.onlineshopping.service.CommentPostServiceImpl;
import au.usyd.onlineshopping.service.UserServiceImpl;

@Controller
public class ReplyController {
	
	@Autowired
	public CommentPostServiceImpl commentPostService;
	@Autowired
	public UserServiceImpl userService;
	
	@RequestMapping (value = "/reply/add", method = RequestMethod.POST)
	public ModelAndView addReply(HttpServletRequest request, HttpSession session) {
		
		Integer postId=Integer.parseInt(request.getParameter("postId"));
		Integer replyUserId= Integer.parseInt(request.getParameter("replyUserId"));
		String content= request.getParameter("content");
		
		//create a reply
		CommentPost commentPost= new CommentPost();
		commentPost.setPostId(postId);
		commentPost.setCommentUserId(replyUserId);
		commentPost.setContent(content);
		
		boolean ifSucc= commentPostService.addReply(commentPost);
		
		ModelAndView view=new ModelAndView("redirect:/t/" + postId);
		return view;
	}
}