package com.robinbookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.robinbookstore.models.Book;
import com.robinbookstore.service.impl.BookSearchService;

@Controller
@RequestMapping("/search")
public class SearchController {

	@Autowired
	private BookSearchService bookSearchService;
	
	@RequestMapping(value = "/searchByBookId", method = RequestMethod.GET)
	public String searchByBookId(@RequestParam(name = "bookId") String bookId, Model model) {
		
		Book book = bookSearchService.searchByBookId(Integer.parseInt(bookId));
		
		if(book == null)
			return "noBookExistPage";
		
		model.addAttribute("singleBook", book);
		return "singleBookSearchResultPage";
	}
	
	@RequestMapping(value = "/searchByCategory", method = RequestMethod.GET)
	public String searchByCategory(@RequestParam(name = "bookCategory") String bookCategory, Model model) {
		
		List<Book> bookList = bookSearchService.searchByCategory(bookCategory);
		
		if(bookList == null)
			return "noBookExistPage";
		
		model.addAttribute("bookList", bookList);
		return "bookSearchResultPage";
	}
	
	@RequestMapping(value = "/searchByAuthorName",  method = RequestMethod.GET)
	public String searchByAuthorName(@RequestParam(name = "authorName") String authorName, Model model) {
		
		List<Book> bookList = bookSearchService.searchByAuthorName(authorName);
		
		if(bookList == null)
			return "noBookExistPage";
		
		model.addAttribute("bookList", bookList);
		return "bookSearchResultPage";
	}
}
