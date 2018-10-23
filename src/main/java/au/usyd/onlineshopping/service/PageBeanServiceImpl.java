package au.usyd.onlineshopping.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import au.usyd.onlineshopping.Entity.Book;
import au.usyd.onlineshopping.Entity.PageBean;
import au.usyd.onlineshopping.dao.BookDao;

@Service
@Transactional
public class PageBeanServiceImpl implements PageBeanService{
	
	@Autowired
	BookDao bookDao;
	
	@Override
	public PageBean<Book> getBookWithPage(int pageNum){
		List<Book> allBook = bookDao.getBooks();
		int totalRecord = allBook.size();
		int pageSize = 3 ;
		PageBean<Book> pb = new PageBean<Book>(pageNum, pageSize, totalRecord);
		int startIndex = pb.getStartIndex();
		//未写完
		pb.setList(bookDao.getBookByPage(startIndex, pageSize));
		return pb;		
	}

}
