package com.reactive.learn.learn.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reactive.learn.learn.entities.Book;
import com.reactive.learn.learn.services.BookService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping("/")
    public Mono<Book> create(@RequestBody Book book){
            return bookService.saveBook(book);
    }

    @GetMapping("/")
    public Flux<Book> getAll(){
        return bookService.getAllBooks();
    }

    @GetMapping("/{bookId}")
    public Mono<Book> getBook(@PathVariable int bookId) {
        return bookService.getBook(bookId);
    }

    @PutMapping("/{bookId}")
    public Mono<Book> updateBook(@PathVariable int bookId,@RequestBody Book book) {
        return bookService.updateBook(book,bookId);
    }
    @DeleteMapping("/{bookId}")
    public Mono<Void> deleteBook(@PathVariable int bookId) {
        return bookService.deleteBook(bookId);
    }

    

}
