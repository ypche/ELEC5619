package au.usyd.onlineshopping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import au.usyd.onlineshopping.Entity.Book;
import au.usyd.onlineshopping.dao.BookDao;



public interface BookService {
	
	public Book getBookById(long id);
	
	public Book getBookByName(String name);
	
	public void addBook(Book book);
	
	public void deleteBook(long id);
	
	public List<Book> getBooksByKeyWord(String KeyWord);
	
	public List<Book> getBooksByGenre(String genre);
	
	public List<Book> getBooks();
	
}
