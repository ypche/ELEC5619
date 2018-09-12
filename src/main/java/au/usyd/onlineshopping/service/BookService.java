package au.usyd.onlineshopping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import au.usyd.onlineshopping.Entity.Book;
import au.usyd.onlineshopping.dao.BookDao;


@Service
@Transactional
public class BookService {
	
	@Autowired
	public BookDao bookDao;
	
	
	public void addBook(Book book) {
		System.out.println(book.toString());
		bookDao.addBook(book);
	}
	
	public List<Book> getBooks(){
		return bookDao.getBooks();
	}
}
