package au.usyd.onlineshopping.Entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import junit.framework.TestCase;

public class BookTest {
	
	private Book book = new Book();
	
	@Test
	public void testSetAndGetTitle() {
		String title = "aTitle";
		assertNull(book.getTitle());
		book.setTitle(title);
		assertEquals("aTitle", book.getTitle());
	}
	
	@Test
	public void testSetAndGetAuthor() {
		String author = "aAuthorName";
		assertNull(book.getAuthor());
		book.setAuthor(author);
		assertEquals("aAuthorName", book.getAuthor());
	}
	
	@Test
	public void testSetAndGetPrice() {
		double price = 22;
		assertEquals(0.0, book.getPrice(),0);
		book.setPrice(price);
		assertEquals(22, book.getPrice(),0);
	}
	
	@Test
	public void testSetAndGetSescription() {
		String description = "aDescription";
		assertNull(book.getAuthor());
		book.setDescription(description);
		assertEquals("aDescription", book.getDescription());
	}
	
	
}











