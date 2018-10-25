package au.usyd.onlineshopping.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import au.usyd.onlineshopping.Entity.Post;
import au.usyd.onlineshopping.Entity.Topic;
import au.usyd.onlineshopping.service.PostService;
import au.usyd.onlineshopping.service.TopicService;

@Controller
@RequestMapping("/forum")
public class ForumController {
	
	@Autowired
	public TopicService topicService;
	
	@Autowired
	public PostService postService;
	
	
	//topic part
	@RequestMapping(value = "/getTopics", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView model = new ModelAndView("index");
		List<Topic> list = topicService.getTopics();
		model.addObject("list", "list");
		return model;
	}
	
	@RequestMapping(value = "/manageTopics", method = RequestMethod.GET)
	public ModelAndView manageTopic() {
		ModelAndView model = new ModelAndView("topiclist");
		List<Topic> list = topicService.getTopics();
		model.addObject("list", list);
		return model;
	}
	
	@RequestMapping(value = "/addTopic", method = RequestMethod.GET)
	public ModelAndView addTopic() {
		ModelAndView model = new ModelAndView("addTopic");
		Topic topic = new Topic();
		model.addObject("topicForm", topic);
		return model;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView getTopicById(@PathVariable("id") long id) {
		ModelAndView model = new ModelAndView("topicTitle");
		Topic topic = (Topic)topicService.getTopicById(id);
		model.addObject("topic", topic);
		return model;
	}
	
	@RequestMapping(value = "/saveTopic", method = RequestMethod.POST)
	public String saveTopic(@ModelAttribute Topic topic, String newTopicTitle) {
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
		List<Topic> list = topicService.getTopicsByKeyWord(keyword);
		model.addObject("searchlist", list);
		return model;
	}
	
	
	//post part
	
	/*@RequestMapping(value = "/getTopics/listPost", method = RequestMethod.GET)
	public ModelAndView listPosts() {
		ModelAndView model = new ModelAndView("post");
		Topic topic = topicService.getTopicById(topicId);
		List<Post> postList = postService.getPostByTopic(topic);
		model.addObject("postList", postList);
		return model;
		
	}*/
}