package au.usyd.onlineshopping.web;

import java.lang.ProcessBuilder.Redirect;
import java.util.List;
import java.util.Map;

import org.hibernate.loader.custom.Return;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@RequestMapping(value = "/getAllBooks", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView model = new ModelAndView("booklist");
		List<Book> list = bookService.getBooks();
		model.addObject("list",list);
		return model;
	}
	
	@RequestMapping(value = "/addBook", method = RequestMethod.GET)
	public ModelAndView addBook() {
		ModelAndView model = new ModelAndView("addBook");
		Book book = new Book();
		model.addObject("bookForm",book);
		return model;
	}
	
	@RequestMapping(value = "/saveBook", method = RequestMethod.POST)
	public String saveBook(@ModelAttribute Book book) {
		bookService.addBook(book);
		return "redirect:/book/getAllBooks";
	}
	
	@RequestMapping(value = "/delete/{id}")
	public String deleteBook(@PathVariable("id") long id) {
		bookService.deleteBook(id);
		return "redirect:/book/getAllBooks";
	}
	
	@RequestMapping(value = "/genre/{genre}")
	public ModelAndView getBooksByGenre(@PathVariable("genre")String genre){
		ModelAndView model = new ModelAndView("genrebooklist");
		List<Book> list = bookService.getBooksByGenre(genre);
		model.addObject("genrelist",list);
		return model;
	}
	
	

	

	
	
	
	
}
