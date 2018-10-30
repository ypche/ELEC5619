package au.usyd.onlineshopping.service;

import java.util.List;

import au.usyd.onlineshopping.Entity.Post;
import au.usyd.onlineshopping.Entity.User;

public interface PostService{
	
	/*public Post getPostById(long id);
	
	public Post getPostContent(String content);
	
	public void addPost(Post post, String newPostContent);
	
	public void deletePost(long id);
	
	public List<Post> getPostByTopic(Topic topic);*/
	
	public List<Post> getAllPosts();
	public Post getPostById(long id);
	public Post getPostByUser(User user);
	public Post addPost(User user, String newContent);
	public List<Post> listPostsAndUsers();
	public Post selectById(Integer id);
	public boolean addPost(Post post);
}