package main.java.ro.ubb.bookstore;

import main.java.ro.ubb.bookstore.controller.BookController;
import main.java.ro.ubb.bookstore.domain.Book;
import main.java.ro.ubb.bookstore.domain.Validators.BookValidator;
import main.java.ro.ubb.bookstore.domain.Validators.Validator;
import main.java.ro.ubb.bookstore.repository.InMemoryRepository;
import main.java.ro.ubb.bookstore.ui.Console;
import main.java.ro.ubb.bookstore.repository.IRepository;
import java.util.Scanner;

public class Main {


    public static void main(String [] args) {

        Scanner input  = new Scanner(System.in);
        Validator<Book> bookValidator = new BookValidator();
        IRepository<Long, Book> bookRepository = new InMemoryRepository<>(bookValidator);
        BookController bookController = new BookController(bookRepository);
        Console console = new Console(bookController);
        console.runConsole();


    }

}

