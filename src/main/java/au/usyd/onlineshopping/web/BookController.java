package au.usyd.onlineshopping.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import au.usyd.onlineshopping.Entity.Book;
import au.usyd.onlineshopping.service.BookService;


@Controller
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	public BookService bookService;
	
	
    @RequestMapping(value = "/newBook", method = RequestMethod.GET)
    public ModelAndView newBook(ModelAndView model) {
        Book book = new Book();
        model.addObject("book", book);
        model.setViewName("addBook");
        return model;
    }
	
	@RequestMapping(value = "/addBook", method = RequestMethod.POST)
	public ModelAndView saveBook(@ModelAttribute Book book) {
		bookService.addBook(book);
		return new ModelAndView("success");
	}
	


	
	
	public String getBook(Map<String,Object>map){
		map.put("bookList", bookService.getBooks());
		return "main";
	}
	
	
}
