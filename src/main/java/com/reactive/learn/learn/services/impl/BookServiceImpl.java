package com.reactive.learn.learn.services.impl;

import org.springframework.stereotype.Service;

import com.reactive.learn.learn.entities.Book;
import com.reactive.learn.learn.repositories.BookRepo;
import com.reactive.learn.learn.services.BookService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final  BookRepo bookRepo;
    @Override
    public Mono<Book> saveBook(Book book) {
        // TODO Auto-generated method stub
        Mono<Book> createdBook = bookRepo.save(book);
        return createdBook; 
    }

    @Override
    public Mono<Book> getBook(Integer id) {
        return bookRepo.findById(id);
    }

    @Override
    public Mono<Book> updateBook(Book book, Integer id) {
       Mono<Book> oldbook = bookRepo.findById(id);
       Mono<Book> newBook = oldbook.flatMap(book1->{
        book1.setName(book.getName());
        book1.setAuthor(book.getAuthor());
        book1.setPublisher(book.getPublisher());
        book1.setDescription(book.getDescription());
        return this.bookRepo.save(book1);
       });
       return newBook;
    }

    @Override
    public Mono<Void> deleteBook(Integer id) {
        return bookRepo.findById(id).flatMap(b->this.bookRepo.delete(b));
    }

    @Override
    public Flux<Book> getAllBooks() {
        return bookRepo.findAll();        
    }

    @Override
    public Flux<Book> search(String query) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'search'");
    }
    
}
