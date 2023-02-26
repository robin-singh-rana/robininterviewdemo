package com.robinbookstore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.robinbookstore.models.Book;
import com.robinbookstore.repository.BookRepository;
import com.robinbookstore.service.BookSearchServiceInterface;

@Service
public class BookSearchService implements BookSearchServiceInterface{
	
	@Autowired
	private BookRepository bookRepository;
	
	@Override
	public Book searchByBookId(int bookId) {
		
		return bookRepository.findById(bookId);
	}

	@Override
	public List<Book> searchByCategory(String bookCategory) {
		
		return bookRepository.findByCategory(bookCategory);
	}

	@Override
	public List<Book> searchByAuthorName(String authorName) {
		
		return bookRepository.findByAuthorName(authorName);
	}
	
}
