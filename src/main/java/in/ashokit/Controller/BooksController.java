package in.ashokit.Controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import in.ashokit.Service.BooksService;
import in.ashokit.entity.Books;

@Controller
public class BooksController {
	
	private BooksService booksService;

	public BooksController(BooksService booksService) {
		this.booksService = booksService;
	}
	
	
	public void showList() {
		
		List<Books> findByAllowst = booksService.findByAllowst("Y");
	}
	
	
	@GetMapping("/AddBooks")
	public ModelAndView show() {
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("books", new Books());
		
		mav.setViewName("AddBooks");
		
		return mav;
		
	}
	
	@PostMapping("/Addbooks")
	public ModelAndView addBookData(Books booksObj) {
		
		ModelAndView mav = new ModelAndView();
		
		boolean bookData = booksService.addBookData(booksObj);
		
		if(bookData) {
			
			mav.addObject("msg", "Successfully Added");
		}else {
			
			mav.addObject("err", "error occured");
		}
			
	    mav.addObject("addbook", booksService.addBookData(booksObj));
		
		mav.setViewName("AddBooks");
		
		return mav;
	}
	
	
	@GetMapping("/books")
	public ModelAndView getAllData() {
		
	ModelAndView mav = new ModelAndView();
	
	mav.addObject("books", booksService.getData());
	
	mav.setViewName("index");
		
		return mav;
	}
	
	@GetMapping("/delete")
	public ModelAndView deleteBook(@RequestParam("bookId")Integer bookId) {
		
		
		if (bookId != null) {
            // Perform logic to delete the book by bookId
            booksService.deleteBook(bookId);
        }
			
		ModelAndView  mav = new ModelAndView();
		
	    mav.setViewName("redirect:/books");
		
		return mav;
	}
	
	@GetMapping("/edit")
	public ModelAndView editBook(@RequestParam("bookId") Integer bookId) {
		
		Books editBook = booksService.editBook(bookId);
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("books", editBook);
		
		mav.setViewName("AddBooks");
	
		return mav;
	}

}
