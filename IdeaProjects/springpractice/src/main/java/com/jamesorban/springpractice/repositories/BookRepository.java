package com.jamesorban.springpractice.repositories;

import com.jamesorban.springpractice.dormain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
