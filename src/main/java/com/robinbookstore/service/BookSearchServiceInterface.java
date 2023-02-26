package com.robinbookstore.service;

import java.util.List;

import com.robinbookstore.models.Book;

public interface BookSearchServiceInterface {
	
	Book searchByBookId(int id);
	
	List<Book> searchByCategory(String category);
	
	List<Book> searchByAuthorName(String name);
}
