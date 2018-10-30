package au.usyd.onlineshopping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import au.usyd.onlineshopping.Entity.CommentPost;
import au.usyd.onlineshopping.Entity.Post;
import au.usyd.onlineshopping.dao.CommentPostDao;

@Service
@Transactional
public class CommentPostServiceImpl implements CommentPostService{
	
	@Autowired
	public CommentPostDao commentDao;

	@Override
	public List<CommentPost> getCommentsByPost(Post post) {
		// TODO Auto-generated method stub
		return commentDao.getCommentsByPost(post);
	}

	@Override
	public void addComment(CommentPost comment) {
		// TODO Auto-generated method stub
		commentDao.addComment(comment);
	}

	@Override
	public void deleteComment(long id) {
		// TODO Auto-generated method stub
		commentDao.deleteComment(id);
	}

	@Override
	public String getPostContent(CommentPost comment) {
		// TODO Auto-generated method stub
		return commentDao.getPostContent(comment);
	}

	@Override
	public void addComment(long userID, Post post) {
		// TODO Auto-generated method stub
		commentDao.addComment(userID, post);
	}

	@Override
	public void displayComments(List<CommentPost> comments) {
		// TODO Auto-generated method stub
		commentDao.displayComments(comments);
	}

	@Override
	public CommentPost getCommentByID(long id) {
		// TODO Auto-generated method stub
		return commentDao.getCommentByID(id);
	}

	@Override
	public List<CommentPost> getCommentsOfPost(Integer postId) {
		// TODO Auto-generated method stub
		return commentDao.getCommentsOfPost(postId);
	}

	@Override
	public boolean addReply(CommentPost commentPost) {
		// TODO Auto-generated method stub
		return commentDao.insert(commentPost)>0;
	}
	
	/*@Override
	public CommentPost getTopicById(long id) {
		return topicDao.getTopicById(id);
	}
	
	@Override
	public CommentPost getTopicByTitle(String title) {
		return topicDao.getTopicByTitle(title);
	}
	
	@Override
	public void addTopic(CommentPost topic, String newTopicTitle) {
		topicDao.addTopic(topic, newTopicTitle);
	}
	
	@Override
	public void deleteTopic(long id) {
		topicDao.deleteTopic(id);
	}
	
	@Override
	public List<CommentPost> getTopicsByKeyWord(String KeyWord) {
		return topicDao.getTopicsByKeyWord(KeyWord);
	}
	
	@Override
	public List<CommentPost> getTopics(){
		return topicDao.getTopics();
	}*/
}