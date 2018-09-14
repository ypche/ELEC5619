package au.usyd.onlineshopping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import au.usyd.onlineshopping.Entity.Book;
import au.usyd.onlineshopping.dao.BookDao;

@Service
@Transactional
public class BookServiceImpl implements BookService{
	
	@Autowired
	BookDao bookDao;

	@Override
	public Book getBookById(long id) {
		return bookDao.getBookById(id);
	}

	@Override
	public Book getBookByName(String name) {
		return bookDao.getBookByName(name);
	}

	@Override
	public void addBook(Book book) {
		bookDao.addBook(book);
	}

	@Override
	public void deleteBook(long id) {
		bookDao.deleteBook(id);
		
	}

	@Override
	public List<Book> getBooksByKeyWord(String KeyWord) {
		return bookDao.getBooksByKeyWord(KeyWord);
	}

	@Override
	public List<Book> getBooksByGenre(String genre) {
		return bookDao.getBooksByGenre(genre);
	}

	@Override
	public List<Book> getBooks() {
		return bookDao.getBooks();
	}

}
