package com.robinbookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.robinbookstore.models.Book;
import com.robinbookstore.service.impl.BookService;

@Controller
@RequestMapping("/book")
public class BookStoreController {
	
	@Autowired
	private BookService bookService;
	
	@RequestMapping(value = "/addBook", method = RequestMethod.POST)
	public String addBook(@RequestParam(name = "bookName") String bookName,
						  @RequestParam(name = "authorName") String authorName,
						  @RequestParam(name = "category") String category) {

		Book book = new Book();
		book.setBookName(bookName);
		book.setAuthorName(authorName);
		book.setCategory(category);
		
		Boolean result = bookService.addBook(book);
		
		if(result.equals(Boolean.FALSE)) {
			return "addBookErrorPage";
		}
		
		return "addBookSuccessPage";
	}
	
	@RequestMapping(value = "/deleteBook", method = RequestMethod.GET)
	public String deleteBook(@RequestParam(name = "bookId") String bookId) {
		
		Boolean result = bookService.deleteBook(Integer.parseInt(bookId));
		
		if(result.equals(Boolean.FALSE)) {
			return "deleteBookErrorPage";
		}
		
		return "deleteBookSuccessPage";
	}
	
	@RequestMapping(value = "/getAllBooks")
	public String getAllBooks(Model model) {

		List<Book> allBooks = bookService.getAllBooks();
		
		if(allBooks.size() == 0)
			return "noBookExistPage";
		
		model.addAttribute("bookList", allBooks);
		
		return "allBooksListPage";
	}
	
	@RequestMapping(value = "/getBookIdToDelete")
	public String getBookIdToDelete() {
		
		return "collectBookInfoToDelete";
	}
	
	@RequestMapping(value = "/addBookInfo")
	public String addBookInfo() {
		
		return "collectBookInfoToAdd";
	}
}
