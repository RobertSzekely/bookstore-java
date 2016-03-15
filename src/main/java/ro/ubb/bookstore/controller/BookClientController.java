package main.java.ro.ubb.bookstore.controller;

import main.java.ro.ubb.bookstore.domain.BookClient;
import main.java.ro.ubb.bookstore.domain.Validators.ValidatorException;
import main.java.ro.ubb.bookstore.repository.IRepository;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Created by Bianca on 14/03/2016.
 */
public class BookClientController {

    private IRepository<Long, BookClient> IRepository;

    public BookClientController(IRepository<Long, BookClient> IRepository) {
        this.IRepository = IRepository;
    }

    /**
     * Adds a bookClient to the repository
     *
     * @param bookClient
     */
    public void addBookClient(BookClient bookClient) throws ValidatorException {
        IRepository.save(bookClient);
    }

    /**
     * Returns all the Clients from the repository that bought a book
     *
     * @return
     */
    public Set<BookClient> getAllBookClients() {
        Iterable<BookClient> bookClients = IRepository.findAll();
        return StreamSupport.stream(bookClients.spliterator(), false).collect(Collectors.toSet());
    }
}
