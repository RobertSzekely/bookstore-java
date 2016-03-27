package main.java.ro.ubb.bookstore;

import main.java.ro.ubb.bookstore.controller.BookClientController;
import main.java.ro.ubb.bookstore.controller.BookController;
import main.java.ro.ubb.bookstore.controller.ClientController;
import main.java.ro.ubb.bookstore.domain.Book;
import main.java.ro.ubb.bookstore.domain.BookClient;
import main.java.ro.ubb.bookstore.domain.Client;
import main.java.ro.ubb.bookstore.domain.Validators.*;
import main.java.ro.ubb.bookstore.repository.*;
import main.java.ro.ubb.bookstore.ui.Console;

import java.util.Scanner;

public class Main {


    public static void main(String [] args) {

        /*
        Validator<Long, Book> bookValidator = new BookValidator();
        IRepository<Long, Book> bookRepository = new InMemoryRepository<>(bookValidator);
        BookController bookController = new BookController(bookRepository);

        Validator<Long, Client> clientValidator = new ClientValidator();
        IRepository<Long, Client> clientRepository = new InMemoryRepository<>(clientValidator);
        ClientController clientController = new ClientController(clientRepository);
        */


        //Validator<Long, Book> bookValidator = new BookValidator();
        //IRepository<Long, Book> bookRepository = new BookXmlRepository(bookValidator, "bookstore.xml";
        //BookController bookController = new BookController(bookRepository);


        //jdbc:postgresql://host:port/database
        String url = "jdbc:postgresql://localhost:5432/postgres";
        Validator<Long,Book> bookValidator = new BookValidator();
        IRepository<Long, Book> bookRepository = new BookDbRepository(url, "your Db username here", "your Db password here" , bookValidator);
        BookController bookController = new BookController(bookRepository);

        Validator<Long,Client> clientValidator = new ClientValidator();
        IRepository<Long, Client> clientRepository = new ClientXmlRepository(clientValidator, "clients.xml");
        ClientController clientController = new ClientController(clientRepository);

        Validator<Long, BookClient> bookClientValidator = new BookClientValidator();
        IRepository<Long, BookClient> bookClientRepository = new BookClientDbRepository(url, "your Db username", "your Db password here", bookClientValidator);
        BookClientController bookClientController = new BookClientController(bookClientRepository);

        Console console = new Console(bookController, clientController, bookClientController);
        console.runConsole();


    }

}
