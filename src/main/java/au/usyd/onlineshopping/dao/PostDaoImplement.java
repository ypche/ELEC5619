package au.usyd.onlineshopping.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import au.usyd.onlineshopping.Entity.Post;
import au.usyd.onlineshopping.Entity.Topic;

@Repository
public class PostDaoImplement implements PostDao {
	
	//protected final Log logger = LogFactory,getLog(getClass());
	
	@Autowired
	public SessionFactory sessionFactory;
	
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public List<Post> getPostByTopic (Topic topic) {
		
		Criteria criteria = getSession().createCriteria(Post.class);
		
		criteria.add(Restrictions.eq("topic", topic));
		List<Post> posts = criteria.list()	;
		return posts;
	}
	
	@Override
	public Post getPostContent(String content) {
		Post post = (Post) getSession().get(Post.class, content);
		return post;
	}
	
	@Override
	public void addPost(Post post, String newPostContent) {
		post.setContent(newPostContent);
		getSession().save(post);
	}
	
	@Override
	public void deletePost(long id) {
		Post post = (Post) getSession().get(Post.class, id);
		getSession().delete(post);
	}

	@Override
	public Post getPostById(long id) {
		// TODO Auto-generated method stub
		Post post = (Post) getSession().get(Post.class, id);
		return post;
	}
	
	
}