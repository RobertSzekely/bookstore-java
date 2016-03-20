package main.java.ro.ubb.bookstore;

import main.java.ro.ubb.bookstore.controller.BookClientController;
import main.java.ro.ubb.bookstore.controller.BookController;
import main.java.ro.ubb.bookstore.controller.ClientController;
import main.java.ro.ubb.bookstore.domain.Book;
import main.java.ro.ubb.bookstore.domain.BookClient;
import main.java.ro.ubb.bookstore.domain.Client;
import main.java.ro.ubb.bookstore.domain.Validators.*;
import main.java.ro.ubb.bookstore.repository.BookXmlRepository;
import main.java.ro.ubb.bookstore.repository.InMemoryRepository;
import main.java.ro.ubb.bookstore.ui.Console;
import main.java.ro.ubb.bookstore.repository.IRepository;
import java.util.Scanner;

public class Main {


    public static void main(String [] args) {

        Scanner input  = new Scanner(System.in);

        /*
        Validator<Book> bookValidator = new BookValidator();
        IRepository<Long, Book> bookRepository = new InMemoryRepository<>(bookValidator);
        BookController bookController = new BookController(bookRepository);
        */

        Validator<Book> bookValidator = new BookValidator();
        IRepository<Long, Book> bookRepository = new BookXmlRepository(bookValidator, "bookstore.xml");
        BookController bookController = new BookController(bookRepository);

        Validator<Client> clientValidator = new ClientValidator();
        IRepository<Long, Client> clientRepository = new InMemoryRepository<>(clientValidator);
        ClientController clientController = new ClientController(clientRepository);

        Validator<BookClient> bookClientValidator = new BookClientValidator();
        IRepository<Long, BookClient> bookClientRepository = new InMemoryRepository<>(bookClientValidator);
        BookClientController bookClientController = new BookClientController(bookClientRepository);

        Console console = new Console(bookController, clientController, bookClientController);
        console.runConsole();


    }

}
