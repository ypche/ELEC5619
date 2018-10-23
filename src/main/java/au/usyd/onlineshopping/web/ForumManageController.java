package au.usyd.onlineshopping.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import au.usyd.onlineshopping.Entity.Board;
import au.usyd.onlineshopping.service.ForumService;

@Controller
public class ForumManageController extends BaseController {
	
	@Autowired
	private ForumService forumService;
	@Autowired
	//private UserService userService;
	
	//list the whole modules of forum
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView listAllBoards() {
		ModelAndView view = new ModelAndView();
			List<Board> boards = forumService.getAllBoards();
			view.addObject("boards", boards);
			view.setViewName("/listAllBoards");
			return view;
	}
	
	
	//increase a new board page
	@RequestMapping(value = "/forum/addBoardPage", method = RequestMethod.GET)
	public String addBoardPage() {
		return "/addBoard";
	}
	
	//increase a new board
	@RequestMapping(value = "/forum/addBoard", method = RequestMethod.POST)
	public String addBoard(Board board) {
		forumService.addBoard(board);
		return "/addBoardSuccess";
	}
	
}