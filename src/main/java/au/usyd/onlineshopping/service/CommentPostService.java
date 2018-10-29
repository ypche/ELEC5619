package au.usyd.onlineshopping.service;

import java.util.List;

import au.usyd.onlineshopping.Entity.CommentPost;
import au.usyd.onlineshopping.Entity.Post;

public interface CommentPostService {
	
	public List<CommentPost> getCommentsByPost(Post post);
	
	public void addComment(CommentPost comment);
	
	public void deleteComment(long id);
	
	public String getPostContent(CommentPost comment);
	
	public void addComment(long userID, Post post);
	
	public void displayComments(List<CommentPost> comments);
	
	public CommentPost getCommentByID(long id);
	
	/*public CommentPost getTopicById(long id);
	
	public CommentPost getTopicByTitle (String title);
	
	public void deleteTopic(long id);
	
	public List<CommentPost> getTopicsByKeyWord(String KeyWord);
	
	public List<CommentPost> getTopics();
	
	public void addTopic(CommentPost topic, String newTopicTitle);*/

}