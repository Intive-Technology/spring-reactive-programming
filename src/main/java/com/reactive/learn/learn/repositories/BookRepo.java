package com.reactive.learn.learn.repositories;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.reactive.learn.learn.entities.Book;

@Repository
public interface BookRepo extends ReactiveCrudRepository<Book,Integer>{
    
}
