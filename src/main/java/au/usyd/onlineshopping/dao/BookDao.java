package au.usyd.onlineshopping.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import au.usyd.onlineshopping.Entity.Book;

@Repository
public class BookDao {
	
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public void addBook(Book book) {
		this.getSession().save(book);
	}
	
	public List<Book> getBooks() {
		// TODO Auto-generated method stub
		return this.getSession().createCriteria(Book.class).list();

	}
	
}
