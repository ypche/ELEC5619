package au.usyd.onlineshopping.service;

import au.usyd.onlineshopping.Entity.Book;
import au.usyd.onlineshopping.Entity.PageBean;

public interface PageBeanService {
	public PageBean<Book> getBookWithPage(int pageNum);
}
