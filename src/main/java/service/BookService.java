package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entity.Book;
import repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;

	public void save(Book book) {
		//this.bookRepository.save(book);
		this.bookRepository.save(book);

	}

	public List<Book> findAll() {
		return this.bookRepository.findAll();
	}

	public Book findById(Long id) {

		return this.bookRepository.findById(id).get();

	}

}
