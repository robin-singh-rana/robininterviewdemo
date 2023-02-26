package com.robinbookstore.service;

import java.util.List;

import com.robinbookstore.models.Book;

public interface BookSearchServiceInterface {
	
	Book searchByBookId(int bookId);
	
	List<Book> searchByCategory(String bookCategory);
	
	List<Book> searchByAuthorName(String authorName);
}
