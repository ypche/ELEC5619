package au.usyd.onlineshopping.web;

import au.usyd.onlineshopping.cons.CommonConstant;
import au.usyd.onlineshopping.dao.Page;
import au.usyd.onlineshopping.Entity.Board;
import au.usyd.onlineshopping.Entity.Topic;
import au.usyd.onlineshopping.Entity.User;


import junit.framework.TestCase;

public class BoardManageControllerTest extends TestCase {
	
	@Test
	public void listBoardTopics() throws Exception {
		request.setRequestURI("/board/listBoardTopics-1");
		request.addParameter("boardId","1");
		request.setMethod("GET");
		ModelAndView mav = handlerAdapter.handle(request, response, controller);
		Board board = (Board) request.getAttribute("board");
		assertNotNull(mav);
		assertEquals(mav.getViewName(), "/listBoardTopics");
		assertNotNull(board);
		assertThat(board.getBoardName(), equalTo("science fiction"));
		assertThat(board.getTopicNum(), greaterThan(1));
	}
	
	@Test
	public void addTopicPage() throws Exception {
		request.setRequestURI("/board/addTopicPage-1");
		request.addParameter("boardId", "1"); // call the url and param
		request.setMethod("GET");
		ModelAndView mav = handlerAdapter.handle(request, response, controller);
		assertNotNull(mav);
		assertEquals(mav.getViewName(), "/addTopic");
	}

	@Test
	public void addTopic()throws Exception  {
		request.setRequestURI("/board/addTopic");
		request.addParameter("boardId", "1");
		request.setMethod("POST");
		
		User user = new User();
		user.setUserId(1);
		user.setUserName("tom");
		user.setPassword("1234");
		request.getSession().setAttribute(CommonConstant.USER_CONTEXT, user);
		session.setAttribute(CommonConstant.USER_CONTEXT, user);
		
		request.addParameter("topicTitle", "the best science fiction");
		request.addParameter("mainPost.postTitle", "science fiction");
		request.addParameter("mainPost.postText", "......");
		
		ModelAndView mav = handlerAdapter.handle(request, response, controller);
		assertNull(mav);
	}

	@Test
	public void listTopicPosts()throws Exception  {
		request.setRequestURI("/board/listTopicPosts-1");
		request.addParameter("topicId", "1"); 
		request.setMethod("GET");
		ModelAndView mav = handlerAdapter.handle(request, response, controller);
		
		Topic topic = (Topic) request.getAttribute("topic");
		Page pagedPost = (Page) request.getAttribute("pagedPost");
		
		assertNotNull(topic);
		assertNotNull(pagedPost);
		assertThat(pagedPost.getPageSize(), greaterThan(1));
		assertNotNull(mav);
		assertEquals(mav.getViewName(), "/listTopicPosts");
	}
	

	@Test
	public void addPost()throws Exception  {
		request.setRequestURI("/board/addPost");
		request.addParameter("boardId", "1"); 
		request.addParameter("topicId", "1");
		request.addParameter("postTitle", "science fiction");
		request.addParameter("postText", "....！");
		request.setMethod("POST");
		
		User user = new User();
		user.setUserId(1);
		user.setUserName("tom");
		user.setPassword("1234");
		request.getSession().setAttribute(CommonConstant.USER_CONTEXT, user);
		session.setAttribute(CommonConstant.USER_CONTEXT, user);
		
		handlerAdapter.handle(request, response, controller);
	}

	@Test
	public void removeBoard()throws Exception  {
		request.setRequestURI("/board/removeBoard");
		request.addParameter("boardIds", "5,6"); 
		request.setMethod("GET");
		handlerAdapter.handle(request, response, controller);
	}

	@Test
	public void removeTopic()throws Exception  {
		request.setRequestURI("/board/removeTopic");
		request.addParameter("topicIds", "6,7"); 
		request.setMethod("GET");
		handlerAdapter.handle(request, response, controller);
	}

	@Test
	public void makeDigestTopic()throws Exception  {
		request.setRequestURI("/board/makeDigestTopic");
		request.addParameter("topicIds", "1,2");
		request.setMethod("GET");
		
		handlerAdapter.handle(request, response, controller);
	}
}