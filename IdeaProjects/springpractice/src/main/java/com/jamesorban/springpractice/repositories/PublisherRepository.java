package com.jamesorban.springpractice.repositories;

import com.jamesorban.springpractice.dormain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
