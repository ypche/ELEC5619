package au.usyd.onlineshopping.dao;

import java.util.Calendar;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import au.usyd.onlineshopping.Entity.Post;
import au.usyd.onlineshopping.Entity.User;



@Repository
public class PostDaoImplement implements PostDao {
	
	//protected final Log logger = LogFactory,getLog(getClass());
	
	@Autowired
	public SessionFactory sessionFactory;
	
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public Post getPostById (long id) {
		
		Post post = (Post) getSession().get(Post.class, id);
		return post;
	}
	
	@Override
	public Post getPostByUser(User user) {
		
		Criteria criteria = getSession().createCriteria(Post.class);
		
		criteria.add(Restrictions.eq("userId", user));
		
		List<Post> list = criteria.list();
		if (list.size() > 0) {
			Post post = list.get(0);
			return post;
		}
		else 
			return null;
	}
	
	@Override
	public List<Post> getAllPosts() {
		
		Criteria criteria = getSession().createCriteria(Post.class);
		
		return (List<Post>)criteria.list();
	}
	
	@Override
	public Post addPost(User user, String newContent) {
		Post post = new Post();
		post.setPostTime(Calendar.getInstance().getTime());
		post.setContent(newContent);
		post.setUser(user);
		post.setUserName(user.getName());
		getSession().save(post);
		return post;
	}

	@Override
	public List<Post> listPostsAndUsers() {
		// TODO Auto-generated method stub
		Criteria criteria = getSession().createCriteria(Post.class);
		
		return (List<Post>)criteria.list();
	}

	@Override
	public Post selectById(Integer id) {
		// TODO Auto-generated method stub
		Post post = (Post) getSession().get(Post.class, id);
		return post;
	}

	@Override
	public int insert(Post record) {
		// TODO Auto-generated method stub
		
		
		return 0; 
	}

	@Override
	public List<Post> findAllTopics() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}