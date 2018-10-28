package au.usyd.onlineshopping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import au.usyd.onlineshopping.Entity.Post;
import au.usyd.onlineshopping.Entity.Topic;
import au.usyd.onlineshopping.dao.PostDao;

@Service
@Transactional
public class PostServiceImpl implements PostService {
	
	@Autowired
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
	}
}