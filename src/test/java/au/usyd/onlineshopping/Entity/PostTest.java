 package au.usyd.onlineshopping.Entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Date;

import org.junit.Test;

public class PostTest {
	 
	 private Post post = new Post();
	 
	 @Test
	 public void testSetAndGetContent() {
		 String content = "aContent";
		 assertNull(post.getContent());
		 post.setContent(content);
		 assertEquals("aContent", post.getContent());
	 }
	 
	 @Test
	 public void testSetAndGetUserName() {
		 String userName="aUserName";
		 assertNull(post.getUserName());
		 post.setUserName(userName);
		 assertEquals("aUserName", post.getUserName());
	 }
	 
	 @Test 
	 public void testSetAndGetId() {
		 long id = 13;
		 assertEquals(0, post.getId(), 0);
		 post.setId(id);
		 assertEquals(13, post.getId(), 0);
	 }
 }
 