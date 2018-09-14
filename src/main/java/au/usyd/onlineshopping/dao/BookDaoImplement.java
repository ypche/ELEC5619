package au.usyd.onlineshopping.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import au.usyd.onlineshopping.Entity.Book;

@Repository
public class BookDaoImplement implements BookDao{

	@Autowired
	public SessionFactory sessionFactory;
	
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public Book getBookById(long id) {
		Book book = (Book) getSession().get(Book.class, id);
		return book;
	}

	@Override
	public Book getBookByName(String name) {
		Book book = (Book) getSession().get(Book.class, name);
		return book;
	}

	@Override
	public void addBook(Book book) {
		getSession().save(book);
	}

	@Override
	public void deleteBook(long id) {
		Book book = (Book) getSession().get(Book.class, id);
		getSession().delete(book);
	}

	@Override
	public List<Book> getBooksByKeyWord(String KeyWord) {
		@SuppressWarnings("unchecked")
		List<Book> books =  getSession().createCriteria(Book.class)
				.add(Restrictions.like("title", "%"+KeyWord+"%")).list();
		return books;
	}

	@Override
	public List<Book> getBooksByGenre(String genre) {
		@SuppressWarnings("unchecked")
		List<Book> books = getSession().createCriteria(Book.class)
				.add(Restrictions.eq("genre", genre)).list();
		return books;
	}

	@Override
	public List<Book> getBooks() {
		Criteria criteria = getSession().createCriteria(Book.class);		
		return (List<Book>)criteria.list();
	}

}


















