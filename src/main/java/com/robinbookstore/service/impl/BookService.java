package com.robinbookstore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.robinbookstore.models.Book;
import com.robinbookstore.repository.BookRepository;
import com.robinbookstore.service.BookServiceInterface;

@Service
public class BookService implements BookServiceInterface{
	
	@Autowired
	private BookRepository bookRepository;
	
	@Override
	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}

	@Override
	public Boolean addBook(Book book) {

		bookRepository.save(book);
		return Boolean.TRUE;
	}

	@Override
	public Boolean deleteBook(int bookId) {
		
		if(bookRepository.findById(bookId) != null)
		{
			bookRepository.deleteById(bookId);
			return Boolean.TRUE;
		}

		return Boolean.FALSE;
	}
}
