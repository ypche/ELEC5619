package au.usyd.onlineshopping.web;

import java.util.List;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import au.usyd.onlineshopping.Entity.Board;
import junit.framework.TestCase;

public class ForumManageControllerTest extends TestCase {
	
	//private ForumManageController controller;
	
	
	//test the board page
	@Test 
	public void testlistAllBoards()throws Exception {
		request.setRequestURI("/index");
		request.setMethod("GET");
		
		//call the controller
		ModelAndView mav = handlerAdapter.handle(request, response, controller);
		List<Board> boards = (List<Board>)request.getAttribute("boards");
		
		//vertify the result
		assertNotNull(mav);
		assertEquals(mav.getViewName(),"/listAllBoards");
		assertNotNull(boards);
		//asserThat(boards.size(), greaterThan(1));
	}
	//test the add board page
	@Test
	public void addBoardPage()throws Exception {
		request.setRequestURI("/forum.addBoardPage");
		request.setMethod("GET");
		
		ModelAndView mav = handlerAdapter.handle(request, response, controller);
		assertNotNull(mav);
		assertEquals(mav.getViewName(), "/addBoard");
	}
	// test add board
	@Test
	public void addBoard()throws Exception{
		request.setRequestURI("/forum/addBoard");
		request.addParameter("boardName", "science fiction");
		request.addParameter("boardDesc", "the best science fiction ");
		request.setMethod("POST");
		ModelAndView mav = handlerAdapter.handle(request, response, controller);
		assertNotNull(mav);
		assertEquals(mav.getViewName(), "/addBoardSuccess");
	}
	
}