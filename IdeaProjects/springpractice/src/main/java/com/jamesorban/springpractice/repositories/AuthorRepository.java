package com.jamesorban.springpractice.repositories;

import com.jamesorban.springpractice.dormain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
