package au.usyd.onlineshopping.web;

import java.io.File;
import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.runner.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
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
	
//	@RequestMapping(value = "/saveBook", method = RequestMethod.POST)
//	public String saveBook(@ModelAttribute Book book) {
//		bookService.addBook(book);
//		return "redirect:/book/getAllBooks";
//	}
	
	
	@RequestMapping(value = "/saveBook", method = RequestMethod.POST)
	public String saveBook(HttpServletRequest request, @ModelAttribute Book book, MultipartFile imgFile) throws Exception, IOException {
		//get original file name
		String originalName = imgFile.getOriginalFilename();
		if(imgFile!=null && originalName!=null && originalName.length()>0){
//			String pic_path = "/image/book_pic/";
			
			String pic_path = "/Users/dan/git/ELEC5619/image/";
			String newFileName = UUID.randomUUID().toString()+originalName.substring(originalName.lastIndexOf("."));
			//new picture
			File newFile = new File(pic_path+newFileName);
//			book.setImage(pic_path+newFileName);
			imgFile.transferTo(newFile);
			bookService.addBook(book,newFileName);
			
		}
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
	

	
	@RequestMapping(value = "/search")
	public ModelAndView searchBooksByKeyword(HttpServletRequest request, 
	        HttpServletResponse response){
		String keyword = request.getParameter("keyword");
		keyword = keyword.trim();
		ModelAndView model = new ModelAndView("searchbooklist");
		List<Book> list = bookService.getBooksByKeyWord(keyword);
		model.addObject("searchlist",list);
		return model;
	}
	
	

	

	
	
	
	
}
