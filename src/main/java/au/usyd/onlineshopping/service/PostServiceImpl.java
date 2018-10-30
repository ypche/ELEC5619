package au.usyd.onlineshopping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import au.usyd.onlineshopping.Entity.Post;
import au.usyd.onlineshopping.Entity.CommentPost;
import au.usyd.onlineshopping.Entity.User;
import au.usyd.onlineshopping.dao.PostDao;

@Service
@Transactional
public class PostServiceImpl implements PostService {
	
	@Autowired
	PostDao postDao;

	@Override
	public List<Post> getAllPosts() {
		// TODO Auto-generated method stub
		return postDao.getAllPosts();
	}

	@Override
	public Post getPostById(long id) {
		// TODO Auto-generated method stub
		return postDao.getPostById(id);
	}

	@Override
	public Post getPostByUser(User user) {
		// TODO Auto-generated method stub
		return postDao.getPostByUser(user);
	}

	@Override
	public Post addPost(User user, String newContent) {
		// TODO Auto-generated method stub
		Post post = postDao.addPost(user, newContent);
		return post;
	}

	@Override
	public List<Post> listPostsAndUsers() {
		// TODO Auto-generated method stub
		return postDao.listPostsAndUsers();
	}

	@Override
	public Post selectById(Integer id) {
		// TODO Auto-generated method stub
		Post post= postDao.selectById(id);
		return post;
	}

	@Override
	public boolean addPost(Post post) {
		// TODO Auto-generated method stub
		return postDao.insert(post)>0;
	}
	
	/*@Autowired
	PostDao postDao;

	@Override
	public Post getPostById(long id) {
		// TODO Auto-generated method stub
		return postDao.getPostById(id);
	}

	@Override
	public Post getPostContent(String content) {
		// TODO Auto-generated method stub
		return postDao.getPostContent(content);
	}

	@Override
	public void addPost(Post post, String newPostContent) {
		// TODO Auto-generated method stub
		postDao.addPost(post, newPostContent);
	}

	@Override
	public void deletePost(long id) {
		// TODO Auto-generated method stub
		postDao.deletePost(id);
		
	}

	@Override
	public List<Post> getPostByTopic(Topic topic) {
		// TODO Auto-generated method stub
		return postDao.getPostByTopic(topic);
	}*/
}