package main.java.ro.ubb.bookstore.controller;

import main.java.ro.ubb.bookstore.domain.Book;
import main.java.ro.ubb.bookstore.domain.Validators.ValidatorException;
import main.java.ro.ubb.bookstore.repository.IRepository;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Created by robertszekely on 27/02/16.
 */
public class BookController {
    private IRepository<Long, Book> IRepository;

    public BookController(IRepository<Long, Book> IRepository) {
        this.IRepository = IRepository;
    }

    public void addBook(Book book) throws ValidatorException {
        IRepository.save(book);
    }

    public Set<Book> getAllBooks() {
        Iterable<Book> books = IRepository.findAll();
        return StreamSupport.stream(books.spliterator(), false).collect(Collectors.toSet());
    }

}
