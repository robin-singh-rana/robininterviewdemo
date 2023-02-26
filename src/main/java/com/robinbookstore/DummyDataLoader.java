package com.robinbookstore;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;
import com.robinbookstore.models.Book;
import com.robinbookstore.repository.BookRepository;

@Component
public class DummyDataLoader implements CommandLineRunner {

	private final BookRepository bookRepository;
	private final Faker faker;
	
	public DummyDataLoader(BookRepository bookRepository, Faker faker) {
		this.bookRepository = bookRepository;
		this.faker = faker;
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		List<Book> books = IntStream.rangeClosed(1, 500)
				.mapToObj(i -> new Book(
						faker.book().title(),
						faker.book().author(),
						faker.book().genre()
						)).collect(Collectors.toList());
		
		
		bookRepository.saveAll(books);
	}

}
