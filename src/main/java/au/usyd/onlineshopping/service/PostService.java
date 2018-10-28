package au.usyd.onlineshopping.service;

import java.util.List;

import au.usyd.onlineshopping.Entity.Post;
import au.usyd.onlineshopping.Entity.Topic;

public interface PostService{
	
	public Post getPostById(long id);
	
	public Post getPostContent(String content);
	
	public void addPost(Post post, String newPostContent);
	
	public void deletePost(long id);
	
	public List<Post> getPostByTopic(Topic topic);
}