package au.usyd.onlineshopping.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import au.usyd.onlineshopping.Entity.Post;
import au.usyd.onlineshopping.Entity.User;
import au.usyd.onlineshopping.Entity.CommentPost;
import au.usyd.onlineshopping.service.PostService;
import au.usyd.onlineshopping.service.UserService;
import au.usyd.onlineshopping.service.CommentPostService;

@Controller
@RequestMapping("/forum")
public class ForumController {
	
	@Autowired
	public CommentPostService commentPostService;
	
	@Autowired
	public PostService postService;
	
	@Autowired
	public UserService userService;
	
	private final Log log = LogFactory.getLog(getClass());
	@RequestMapping(value = "/managePost", method = RequestMethod.GET)
	public ModelAndView	managePost() {
		ModelAndView model = new ModelAndView("postList");
		List<Post> list = postService.getAllPosts();
		return model;
	}
	
	@RequestMapping("postlist")
	public ModelAndView postList() {
		ModelAndView mav= new ModelAndView();
			List<Post> cs= postService.getAllPosts();
			mav.addObject("cs", cs);
			mav.setViewName("postlist");
			return mav;
	}
	
	
	 
	@RequestMapping(value="/getPosts", method=RequestMethod.GET)
	public ModelAndView forum(HttpSession session) {
		ModelAndView model = new ModelAndView("forum");
		/*if(session.getAttribute("userID") == null) {
			model = new ModelAndView("login");
			User user = new User();
			model.addObject("userForm", user);
			return model;
		}*/
		long userID = (Long) session.getAttribute("userID");
		String content = (String) session.getAttribute("newContent");
		User currentUser = userService.getUserById(userID);
		Post post = postService.addPost(currentUser, content);
		if(post == null) {
			post = postService.addPost(currentUser, content);
		}
		post.setUserName(currentUser.getName());
		List<Post> postList = new ArrayList<Post>();
		postList.add(post);
		model.addObject("PostDetail", postList);
		
		List<CommentPost> commentList = commentPostService.getCommentsByPost(post);
		for (CommentPost comment: commentList) {
			comment.setContent(commentPostService.getPostContent(comment));
		}
		model.addObject("CommentList", commentList);
		return model;
	}
	
	/*@RequestMapping("/")
	public ModelAndView toMain(HttpSession session) {
		ModelAndView indexPage=new ModelAndView("cate");
		List<Post> posts=postService.listPostsAndUsers();
		
		Integer uid=(Integer) session.getAttribute("userID");
		User user = userService.getUserById(uid);
		
		indexPage.addObject("posts", posts);
		indexPage.addObject("user",user);
		return indexPage;
	}*/
	
	//get the detail info
	/*@RequestMapping("/t/{id}")
	public ModelAndView toTopic(@PathVariable("id")Integer id,HttpSession session) {
		Post post= postService.selectById(id);
		
		List<CommentPost> commentPost = commentPostService.getCommentsOfPost(id);
		
		Integer uid=(Integer) session.getAttribute("userID");
		User user= userService.getUserById(uid);
		
		ModelAndView postPage = new ModelAndView("detail");
		postPage.addObject("post", post);
		postPage.addObject("commentPost", commentPost);
		postPage.addObject("user", user);
		return postPage;
	}	*/
	
	//post
	/*@RequestMapping(value = "/post/add", method = RequestMethod.POST)
	public ModelAndView addPost(HttpServletRequest request,HttpSession session) {
		ModelAndView indexPage;
		Integer userId=(Integer) session.getAttribute("userID");
		String content= request.getParameter("content");
		//add a new post
		Post post = new Post();
		post.setUserId(userId);
		post.setContent(content);
		//post.setCreateTime(new Date());
		//post.setUpdateTime(new Date());
		boolean ifSucc = postService.addPost(post);
		if(ifSucc) {
			if (log.isInfoEnabled()) {
				log.info("add post success!");
			}
		}
		indexPage=new ModelAndView("redirect:/");
		return indexPage;
	}*/
	
	@RequestMapping(value="/delete/{id}")
	public String deleteComment(@PathVariable("id") long id)	{
		commentPostService.deleteComment(id);
		return "redirect:/forum";
	}
	
	@RequestMapping (value="addComment/{bid}")
	public String addCommentPost(@PathVariable("bid") long bid, HttpSession session) {
		if (session.getAttribute("userID") == null) {
			return "redirect:/user/login";
		}
		long userID = (Long) session.getAttribute("userID");
		User currentUser = userService.getUserById(userID);
		String content = (String) session.getAttribute("newContent");
		Post post = postService.getPostByUser(currentUser);
		if (post == null) {
			post = postService.addPost(currentUser, content);
		}
		post.setUserName(currentUser.getName());
		commentPostService.addComment(bid, post);
		return "redirect:/forum";
 	}
	
	@RequestMapping(value = "/addPost", method = RequestMethod.GET)
	public ModelAndView addPost() {
		ModelAndView model = new ModelAndView("addPost");
		Post post = new Post();
		model.addObject("postForm",post);
		return model;
	}
	
	@RequestMapping(value = "/addComments", method = RequestMethod.GET)
	public ModelAndView addComments() {
		ModelAndView model = new ModelAndView("addComments");
		CommentPost commentPost = new CommentPost();
		model.addObject("commentsForm", commentPost);
		return model;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView getPostById(@PathVariable("id") long id) {
		ModelAndView model = new ModelAndView("postDetail");
		Post post = (Post)postService.getPostById(id);
		model.addObject("post", post);
		return model;
	}
	
	
	@RequestMapping(value ="/savePost", method = RequestMethod.POST)
	public String savePost(HttpServletRequest request, @ModelAttribute Post post, String content, User user) throws Exception, IOException {
		
		String postContent = content;
		postService.addPost(user, postContent);
		return "redirect:/forum/getPosts";
	}
	
	@RequestMapping(value = "/saveComment", method = RequestMethod.POST)
	public String saveComment(HttpServletRequest request, @ModelAttribute CommentPost commentPost, String content) throws Exception, IOException{
		String commentContent = content;
		commentPostService.addReply(commentPost);
		return "redirect:/forum/getPosts";
	}
	/*//post part
	@RequestMapping(value = "/getTopics", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView model = new ModelAndView("index");
		List<CommentPost> list = topicService.getTopics();
		model.addObject("list", "list");
		return model;
	}
	
	@RequestMapping(value = "/manageTopics", method = RequestMethod.GET)
	public ModelAndView manageTopic() {
		ModelAndView model = new ModelAndView("topiclist");
		List<CommentPost> list = topicService.getTopics();
		model.addObject("list", list);
		return model;
	}
	
	@RequestMapping(value = "/addTopic", method = RequestMethod.GET)
	public ModelAndView addTopic() {
		ModelAndView model = new ModelAndView("addTopic");
		CommentPost topic = new CommentPost();
		model.addObject("topicForm", topic);
		return model;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView getTopicById(@PathVariable("id") long id) {
		ModelAndView model = new ModelAndView("topicTitle");
		CommentPost topic = (CommentPost)topicService.getTopicById(id);
		model.addObject("topic", topic);
		return model;
	}
	
	@RequestMapping(value = "/saveTopic", method = RequestMethod.POST)
	public String saveTopic(@ModelAttribute CommentPost topic, String newTopicTitle) {
		topicService.addTopic(topic, newTopicTitle);
		return "redirect:/topic/getTopics";
	}
	
	@RequestMapping(value = "/delete/{id}")
	public String deleteTopic(@PathVariable("id") long id)	{
		topicService.deleteTopic(id);
		return "redirect:/topic/manageTopics";
	}
	
	@RequestMapping(value = "/search")
	public ModelAndView searchTopicsByKeyWord(HttpServletRequest request, HttpServletResponse response) {
		String keyword = request.getParameter("keyword");
		keyword = keyword.trim();
		ModelAndView model = new ModelAndView("searchbooklist");
		List<CommentPost> list = topicService.getTopicsByKeyWord(keyword);
		model.addObject("searchlist", list);
		return model;
	}
	
	
	//post part
	
	@RequestMapping(value = "/getTopics/listPost", method = RequestMethod.GET)
	public ModelAndView listPosts() {
		ModelAndView model = new ModelAndView("post");
		Topic topic = topicService.getTopicById(topicId);
		List<Post> postList = postService.getPostByTopic(topic);
		model.addObject("postList", postList);
		return model;
		
	}*/
}