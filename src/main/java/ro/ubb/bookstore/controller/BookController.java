package main.java.ro.ubb.bookstore.controller;

import main.java.ro.ubb.bookstore.domain.Book;
import main.java.ro.ubb.bookstore.domain.Validators.ValidatorException;
import main.java.ro.ubb.bookstore.repository.Repository;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Created by robertszekely on 27/02/16.
 */
public class BookController {
    private Repository<Long, Book> repository;

    public BookController(Repository<Long, Book> repository) {
        this.repository = repository;
    }

    public void addBook(Book book) throws ValidatorException {
        repository.save(book);
    }

    public Set<Book> getAllBooks() {
        Iterable<Book> books = repository.findAll();
        return StreamSupport.stream(books.spliterator(), false).collect(Collectors.toSet());
    }

}
