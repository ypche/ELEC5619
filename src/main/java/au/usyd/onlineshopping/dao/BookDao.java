package au.usyd.onlineshopping.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import au.usyd.onlineshopping.Entity.Book;


public interface BookDao {
	

	
	public Book getBookById(long id);
	
	public Book getBookByName(String name);
	
//	public void addBook(Book book);
	public void addBook(Book book, String newFileName); 
	
	public void deleteBook(long id);
	
	public List<Book> getBooksByKeyWord(String KeyWord);
	
	public List<Book> getBooksByGenre(String genre);
	
	public List<Book> getBooks();
	
	public List<Book> getBookByPage(int startIndex, int pageSize);
	

	

	
	
}
