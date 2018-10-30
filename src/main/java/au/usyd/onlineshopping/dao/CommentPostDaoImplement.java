package au.usyd.onlineshopping.dao;

import java.util.List;


import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import au.usyd.onlineshopping.Entity.CommentPost;
import au.usyd.onlineshopping.Entity.Post;
import au.usyd.onlineshopping.Entity.User;


@Repository
public class CommentPostDaoImplement implements CommentPostDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	public UserDao userDao;
	
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public List<CommentPost> getCommentsByPost(Post post) {
		// TODO Auto-generated method stub
		Criteria criteria =getSession().createCriteria(CommentPost.class);
		criteria.add(Restrictions.eq("post", post));
		List<CommentPost> comments = criteria.list();
		return comments;
	}

	@Override
	public CommentPost getCommentByID(long id) {
		// TODO Auto-generated method stub
		CommentPost comment = (CommentPost) getSession().get(CommentPost.class, id);
		return comment;
	}

	@Override
	public String getPostContent(CommentPost comment) {
		// TODO Auto-generated method stub
		return comment.getPost().getContent();
	}

	@Override
	public void addComment(CommentPost comment) {
		// TODO Auto-generated method stub
		getSession().save(comment);
	}

	@Override
	public void deleteComment(long id) {
		// TODO Auto-generated method stub
		CommentPost comment = (CommentPost) getSession().get(CommentPost.class, id);
		getSession().delete(comment);
	}

	@Override
	public void addComment(long userID, Post post) {
		// TODO Auto-generated method stub
		User user = userDao.getUserById(userID);
		CommentPost comment = new CommentPost();
		comment.setUser(user);
		comment.setPost(post);
		getSession().save(comment);
	}

	@Override
	public void displayComments(List<CommentPost> comments) {
		// TODO Auto-generated method stub
		if (comments.size()==0)
			return;
		
		for (CommentPost comment: comments) {
			getSession().merge(comment);
		}
	}

	@Override
	public List<CommentPost> getCommentsOfPost(Integer postId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertSelective(CommentPost record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(CommentPost record) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	/*@Autowired
	public SessionFactory sessionFactory;
	
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public Topic getTopicById(long id) {
		Topic topic = (Topic) getSession().get(Topic.class, id);
		return topic;
	}
	
	@Override
	public Topic getTopicByTitle(String title) {
		Topic topic = (Topic) getSession().get(Topic.class,	title);
		return topic;
	}
	
	@Override
	public void addTopic(Topic topic, String newTopicTitle) {
		topic.setTitle(newTopicTitle);
		getSession().save(topic);
	}
	
	@Override
	public void deleteTopic (long id) {
		Topic topic = (Topic) getSession().get(Topic.class, id);
		getSession().delete(topic);
	}
	
	@Override
	public List<Topic> getTopicsByKeyWord(String KeyWord){
		@SuppressWarnings("unchecked")
		List<Topic> topics = getSession().createCriteria(Topic.class).add(Restrictions.like("title", "%" +KeyWord +"%")).list();
		return topics;
		
	}
	
	@Override
	public List<Topic> getTopics() {
		Criteria criteria = getSession().createCriteria(Topic.class);
		return (List<Topic>)criteria.list();
	}*/
	
}