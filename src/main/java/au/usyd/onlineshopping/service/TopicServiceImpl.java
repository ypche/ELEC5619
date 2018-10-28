package au.usyd.onlineshopping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import au.usyd.onlineshopping.Entity.Topic;
import au.usyd.onlineshopping.dao.TopicDao;

@Service
@Transactional
public class TopicServiceImpl implements TopicService{
	
	@Autowired
	TopicDao topicDao;
	
	@Override
	public Topic getTopicById(long id) {
		return topicDao.getTopicById(id);
	}
	
	@Override
	public Topic getTopicByTitle(String title) {
		return topicDao.getTopicByTitle(title);
	}
	
	@Override
	public void addTopic(Topic topic, String newTopicTitle) {
		topicDao.addTopic(topic, newTopicTitle);
	}
	
	@Override
	public void deleteTopic(long id) {
		topicDao.deleteTopic(id);
	}
	
	@Override
	public List<Topic> getTopicsByKeyWord(String KeyWord) {
		return topicDao.getTopicsByKeyWord(KeyWord);
	}
	
	@Override
	public List<Topic> getTopics(){
		return topicDao.getTopics();
	}
}