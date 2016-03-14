package main.java.ro.ubb.bookstore.controller;

import main.java.ro.ubb.bookstore.domain.Book;
import main.java.ro.ubb.bookstore.domain.Validators.ValidatorException;
import main.java.ro.ubb.bookstore.repository.IRepository;

import java.util.HashSet;
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

    public void  deleteBook(long id) throws IllegalArgumentException {
        IRepository.delete(id);
    }

    public void updateBook(Book book) throws ValidatorException {
        IRepository.update(book);
    }

    public Set<Book> getAllBooks() {
        Iterable<Book> books = IRepository.findAll();
        return StreamSupport.stream(books.spliterator(), false).collect(Collectors.toSet());
    }

    public Set<Book> filterBooksByAuthor(String s) {
        Iterable<Book> books = IRepository.findAll();

        Set<Book> filteredBooks = new HashSet<>();
        books.forEach(filteredBooks::add);
        filteredBooks.removeIf(book -> !book.getAuthor().contains(s));

        return filteredBooks;
    }

    public Set<Book> filterBooksByTitle(String s) {
        Iterable<Book> books = IRepository.findAll();

        Set<Book> filteredBooks = new HashSet<>();
        books.forEach(filteredBooks::add);
        filteredBooks.removeIf(book -> !book.getTitle().contains(s));

        return filteredBooks;
    }

    public Set<Book> filterBooksByPrice(Float lowerBound, Float upperBound) {
        Iterable<Book> books = IRepository.findAll();

        Set<Book> filteredBooks = new HashSet<>();
        books.forEach(filteredBooks::add);
        filteredBooks.removeIf(book -> book.getPrice() < lowerBound);
        filteredBooks.removeIf(book -> book.getPrice() > upperBound);

        return filteredBooks;
    }

    public boolean checkExistance(Book book) {
        Iterable<Book> books = IRepository.findAll();

        for (Book b: books)
            if (b.getId() == book.getId())
                return true;

        return  false;
    }

}
