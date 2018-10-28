package au.usyd.onlineshopping.service;

import java.util.List;

import au.usyd.onlineshopping.Entity.Topic;

public interface TopicService {
	
	public Topic getTopicById(long id);
	
	public Topic getTopicByTitle (String title);
	
	public void deleteTopic(long id);
	
	public List<Topic> getTopicsByKeyWord(String KeyWord);
	
	public List<Topic> getTopics();
	
	public void addTopic(Topic topic, String newTopicTitle);

}