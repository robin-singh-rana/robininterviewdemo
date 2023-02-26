package com.robinbookstore.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.robinbookstore.models.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer>{

	Book findById(int bookId);
	
	List<Book> findByCategory(String bookCategory);
	
	List<Book> findByAuthorName(String authorName);
	
	List<Book> findAll();
	
	void deleteById(int bookId);
	
	Book save(Book book);
}
