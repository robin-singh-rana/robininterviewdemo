package com.robinbookstore.service;

import java.util.List;

import com.robinbookstore.models.Book;

public interface BookServiceInterface {
	
	Boolean addBook(Book book);
	
	Boolean deleteBook(int id);
	
	List<Book> getAllBooks();
}
