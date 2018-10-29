package au.usyd.onlineshopping.dao;

import java.util.List;

import au.usyd.onlineshopping.Entity.CommentPost;
import au.usyd.onlineshopping.Entity.Post;


public interface CommentPostDao {
	
	public List<CommentPost> getCommentsByPost(Post post);
	
	public CommentPost getCommentByID(long id);
	
	public String getPostContent(CommentPost comment);
	
	public void addComment(CommentPost comment);
	
	public void deleteComment(long id);
	
	public void addComment(long userID, Post post);
	
	public void displayComments(List<CommentPost> comments);
	
	/*public Topic getTopicById(long id);
	
	public Topic getTopicByTitle(String title);
	
	public void addTopic(Topic topic, String newTopicTitle);
	
	public void deleteTopic(long id);
	
	public List<Topic> getTopicsByKeyWord(String KeyWord);
	
	public List<Topic> getTopics();*/
}