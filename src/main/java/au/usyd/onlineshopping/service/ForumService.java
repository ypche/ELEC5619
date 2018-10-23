package au.usyd.onlineshopping.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import au.usyd.onlineshopping.Entity.Board;
import au.usyd.onlineshopping.Entity.MainPost;
import au.usyd.onlineshopping.Entity.Post;
import au.usyd.onlineshopping.Entity.Topic;
import au.usyd.onlineshopping.dao.BoardDao;
import au.usyd.onlineshopping.dao.Page;
import au.usyd.onlineshopping.dao.PostDao;
import au.usyd.onlineshopping.dao.TopicDao;

@Service 
public class ForumService {
	@Autowired
	private TopicDao topicDao;
	
	
	@Autowired
	private BoardDao boardDao;
	
	@Autowired
	private PostDao postDao;
	
	
	public void addTopic(Topic topic) {
		
		Board board = (Board) boardDao.get(topic.getBoardId());
		board.setTopicNum(board.getTopicNum() +1 );
		topicDao.save(topic);
		
		topic.getMainPost().setTopic(topic);
		MainPost post = topic.getMainPost();
		post.setCreateTime(new Date());
		post.setUser(topic.getUser());
		post.setPostTitle(topic.getTopicTitle());
		post.setBoardId(topic.getBoardId());
		postDao.save(topic.getMainPost());
	}
	
	public void removeTopic(int topicId) {
		Topic topic = topicDao.get(topicId);
		
		Board board = boardDao.get(topic.getBoardId());
		board.setTopicNum(board.getTopicNum() - 1);
		
		topicDao.remove(topic);
		postDao.deleteTopicPosts(topicId);
	}
	
	public void addPost(Post post) {
		postDao.save(post);
		
		Topic topic = topicDao.get(post.getTopic().getTopicId());
		topic.setReplies(topic.getReplies() + 1);
		topic.setLastPost(new Date());
	}
	
	public void removePost(int postId) {
		Post post = postDao.get(postId);
		postDao.remove(post);
		
		
		Topic topic = topicDao.get(post.getTopic().getTopicId());
		topic.setReplies(topic.getReplies() - 1);
	}
	
	public void addBoard(Board board) {
		boardDao.save(board);
	}
	
	public void removeBoard(int boardId) {
		Board board = boardDao.get(boardId);
		boardDao.remove(board);
	}
	//set digest topic
	public void makeDigestTopic(int topicId) {
		Topic topic = topicDao.get(topicId);
		topic.setDigest(Topic.DIGEST_TOPIC);
		
	}
	
	//get the whole board
	public List<Board> getAllBoards(){
		return boardDao.loadAll();
	
	}
	//get the specific page of board
	public Page getPagedTopics(int boardId, int pageNo, int pageSize) {
		return topicDao.getPagedTopics(boardId, pageNo, pageSize);	
	}
	//get the every post of specific board
	public Page getPagedPosts(int topicId, int pageNo, int pageSize) {
		return postDao.getPagedPosts(topicId, pageNo, pageSize);
	}
	
	//search the whole topics with the title
	public Page queryTopicByTitle(String title, int pageNo, int pageSize) {
		return topicDao.queryTopicByTitle(title, pageNo, pageSize);
	}
	
	public Board getBoardById(int boardId) {
		return boardDao.get(boardId);
	}
	
	public Topic getTopicByTopicId(int topicId) {
		return topicDao.get(topicId);
	}
	
	//get the id of publish post
	public Post getPostByPostId(int postId) {
		return postDao.get(postId);
	}
	
	public void updateTopic(Topic topic) {
		topicDao.update(topic);
	}
	
	public void updatePost(Post post) {
		postDao.update(post);
	}
}