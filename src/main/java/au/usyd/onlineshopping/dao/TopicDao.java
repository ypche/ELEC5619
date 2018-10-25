package au.usyd.onlineshopping.dao;

import java.util.List;

import au.usyd.onlineshopping.Entity.Topic;

public interface TopicDao {
	
	public Topic getTopicById(long id);
	
	public Topic getTopicByTitle(String title);
	
	public void addTopic(Topic topic, String newTopicTitle);
	
	public void deleteTopic(long id);
	
	public List<Topic> getTopicsByKeyWord(String KeyWord);
	
	public List<Topic> getTopics();
}