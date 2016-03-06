package main.java.ro.ubb.bookstore.repository;

import main.java.ro.ubb.bookstore.domain.Book;
import main.java.ro.ubb.bookstore.domain.Client;

import java.util.List;

/**
 * Created by robertszekely on 27/02/16.
 */
public interface IRepository {

    List<Book> getBookList();
    List<Client> getClientList();

    void addClient(Client client);
    void addBook(Book book);
}
