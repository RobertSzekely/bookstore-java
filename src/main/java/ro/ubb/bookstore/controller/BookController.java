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

    /**
     * Adds a book to the repository
     *
     * @param book
     */
    public void addBook(Book book) throws ValidatorException {
        IRepository.save(book);
    }

    /**
     * Deletes a book from the repository
     *
     * @param id
     */
    public void  deleteBook(long id) throws IllegalArgumentException {
        IRepository.delete(id);
    }
    /**
     * Updates a book from the repository
     *
     * @param book
     */
    public void updateBook(Book book) throws ValidatorException {
        IRepository.update(book);
    }

    /**
     * Returns all books saved in the repository
     *
     * @return
     */
    public Set<Book> getAllBooks() {
        Iterable<Book> books = IRepository.findAll();
        return StreamSupport.stream(books.spliterator(), false).collect(Collectors.toSet());
    }

    /**
     * Returns all books whose author contain the given string.
     *
     * @param s
     * @return
     */
    public Set<Book> filterBooksByAuthor(String s) {
        Iterable<Book> books = IRepository.findAll();

        Set<Book> filteredBooks = new HashSet<>();
        books.forEach(filteredBooks::add);
        filteredBooks.removeIf(book -> !book.getAuthor().contains(s));

        return filteredBooks;
    }
    /**
     * Returns all books whose title contain the given string.
     *
     * @param s
     * @return
     */
    public Set<Book> filterBooksByTitle(String s) {
        Iterable<Book> books = IRepository.findAll();

        Set<Book> filteredBooks = new HashSet<>();
        books.forEach(filteredBooks::add);
        filteredBooks.removeIf(book -> !book.getTitle().contains(s));

        return filteredBooks;
    }
    /**
     * Returns all books which have the price between an given interval;
     *
     * @param lowerBound, upperBound
     * @return
     */
    public Set<Book> filterBooksByPrice(Float lowerBound, Float upperBound) {
        Iterable<Book> books = IRepository.findAll();

        Set<Book> filteredBooks = new HashSet<>();
        books.forEach(filteredBooks::add);
        filteredBooks.removeIf(book -> book.getPrice() < lowerBound);
        filteredBooks.removeIf(book -> book.getPrice() > upperBound);

        return filteredBooks;
    }


    /**
     * Checks if a book is already in the repository
     *
     * @param  book
     * @return boolean
     */
    public boolean checkExistance(Book book) {
        Iterable<Book> books = IRepository.findAll();

        for (Book b: books)
            if (b.getId() == book.getId())
                return true;

        return  false;
    }

}
