package au.usyd.onlineshopping.Entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class CommentPostTest {
	
	private CommentPost commentPost = new CommentPost();
	
	@Test 
	public void testSetAndGetContent() {
		String content = "aContent";
		assertNull(commentPost.getContent());
		commentPost.setContent(content);
		assertEquals("aContent", commentPost.getContent());
	}
		 
}