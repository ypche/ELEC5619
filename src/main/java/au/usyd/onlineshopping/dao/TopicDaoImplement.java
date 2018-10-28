package au.usyd.onlineshopping.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import au.usyd.onlineshopping.Entity.Topic;

@Repository
public class TopicDaoImplement implements TopicDao{
	
	
	@Autowired
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
	}
	
}