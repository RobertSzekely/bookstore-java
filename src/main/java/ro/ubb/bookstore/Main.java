package main.java.ro.ubb.bookstore;

import main.java.ro.ubb.bookstore.controller.BookController;
import main.java.ro.ubb.bookstore.controller.ClientController;
import main.java.ro.ubb.bookstore.domain.Book;
import main.java.ro.ubb.bookstore.domain.Client;
import main.java.ro.ubb.bookstore.domain.Validators.BookValidator;
import main.java.ro.ubb.bookstore.domain.Validators.ClientValidator;
import main.java.ro.ubb.bookstore.domain.Validators.Validator;
import main.java.ro.ubb.bookstore.domain.Validators.ValidatorException;
import main.java.ro.ubb.bookstore.repository.InMemoryRepository;
import main.java.ro.ubb.bookstore.ui.Console;
import main.java.ro.ubb.bookstore.repository.IRepository;
import java.util.Scanner;
import java.util.Set;

public class Main {


    public static void main(String [] args) {

        Scanner input  = new Scanner(System.in);

        Validator<Book> bookValidator = new BookValidator();
        IRepository<Long, Book> bookRepository = new InMemoryRepository<>(bookValidator);
        BookController bookController = new BookController(bookRepository);

        Validator<Client> clientValidator = new ClientValidator();
        IRepository<Long, Client> clientRepository = new InMemoryRepository<>(clientValidator);
        ClientController clientController = new ClientController(clientRepository);

        Console console = new Console(bookController, clientController);
        console.runConsole();


    }

}
