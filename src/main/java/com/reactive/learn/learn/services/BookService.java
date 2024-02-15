package com.reactive.learn.learn.services;

import com.reactive.learn.learn.entities.Book;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BookService {
    public Mono<Book> saveBook(Book book);
    public Mono<Book> getBook(Integer id);
    public Mono<Book> updateBook(Book book , Integer id);
    public Mono<Void> deleteBook(Integer id);
    public Flux<Book> getAllBooks();
    public Flux<Book> search(String query);

}
