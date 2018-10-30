package au.usyd.onlineshopping.dao;

import java.util.List;

import au.usyd.onlineshopping.Entity.CommentPost;
import au.usyd.onlineshopping.Entity.Post;


public interface CommentPostDao {
	
	//int insert(CommentPost record);
	
	int insertSelective(CommentPost record);
	
	List<CommentPost> getCommentsOfPost(Integer postId);
	
	
	
	public List<CommentPost> getCommentsByPost(Post post);
	
	int insert(CommentPost record);
	
	public CommentPost getCommentByID(long id);
	
	public String getPostContent(CommentPost comment);
	
	public void addComment(CommentPost comment);
	
	public void deleteComment(long id);
	
	public void addComment(long userID, Post post);
	
	public void displayComments(List<CommentPost> comments);
	
	//List<CommentPost> getCommentsOfPost(Integer postId);
	
	/*public Topic getTopicById(long id);
	
	public Topic getTopicByTitle(String title);
	
	public void addTopic(Topic topic, String newTopicTitle);
	
	public void deleteTopic(long id);
	
	public List<Topic> getTopicsByKeyWord(String KeyWord);
	
	public List<Topic> getTopics();*/
}