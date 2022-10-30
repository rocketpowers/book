package repository;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

import entity.Book;

public interface BookRepository extends CrudRepository<Book, Long> {

	@Override
	List<Book> findAll();
	
}
