package main.java.ro.ubb.bookstore.ui;

import main.java.ro.ubb.bookstore.controller.BookController;
import main.java.ro.ubb.bookstore.domain.Book;
import main.java.ro.ubb.bookstore.domain.Validators.ValidatorException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by robertszekely on 27/02/16.
 */
public class Console {
    private BookController bookController;

    public Console(BookController bookController) {
        this.bookController = bookController;
    }

    public void runConsole() {
        //printMainMenu();
        //addBook();
        //printAllBooks();
        mainMenu();
    }


    Scanner input  = new Scanner(System.in).useDelimiter("\n");;


    public void printMainMenu() {
        System.out.println("\n (0) Exit\n\n"
                + "Options for books:\n"
                + "(1) Print all books\n"
                + "(2) Add a book\n"
                + "(3) Delete a book\n"
                + "(4) Update a book\n"
                + "(5) Filter books by title\n"
                + "(6) Filter books by author\n"
                + "(7) Filter books by price\n"
                + "---------------------\n"
                + "Options for clients:\n"
                + "(8) Print all clients\n"
                + "(9) Buy a book\n"
                + "(10) Add a client\n"
                + "(11) Delete a client\n"
                + "(12) Update a client\n"
                + "(13) Filter clients by last name\n"
                + "(14) Filter clients by total money spent\n"
        );

    }

    public void printAllBooks() {
        Set<Book> books = bookController.getAllBooks();
        books.stream().forEach(System.out::println);

    private void addBooks() {
        while(true) {
            Book book = readBook();
            if(book == null || book.getId() < 0) {
                break;
            }
            try {
                bookController.addBook(book);
            } catch (ValidatorException e) {
                e.printStackTrace();
            }
        }
    }
    private void addBook() {
        Book book = readBook();
        try {
            bookController.addBook(book);
        } catch (ValidatorException e) {
            e.printStackTrace();
        }

    }
    private Book readBook() {
        System.out.println("Read book {id, ISBN, title, author, price, units");

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            Long id = Long.valueOf(bufferedReader.readLine());
            String ISBN = bufferedReader.readLine();
            String title = bufferedReader.readLine();
            String author = bufferedReader.readLine();
            Float price = Float.valueOf(bufferedReader.readLine());
            int units = Integer.parseInt(bufferedReader.readLine());

            Book book = new Book(ISBN, title, author, price, units);
            book.setId(id);

            return book;

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;

    }


    private void mainMenu() {
        int opt;

        do {
            printMainMenuOptions();
            boolean cont = true;
            opt = 0;
            do {
                System.out.print("\nEnter option: ");
                opt = input.nextInt();
                cont = false;
            } while (cont == true);

            switch(opt) {
                case 1:
                    printAllBooks();
                    break;
                case 2:
                    addBook();
                    break;
                case 3:
                    //// TODO: 27/02/16
                    break;
                case 4:
                    // TODO: 27/02/16
                    break;
                case 5:
                    // TODO: 27/02/16
                    break;
                case 6:
                    // TODO: 27/02/16
                case 7:
                    // TODO: 27/02/16
                    break;
                case 8:
                    // TODO: 27/02/16
                    break;
                case 9:
                    // TODO: 27/02/16
                    break;
                case 10:
                    // TODO: 27/02/16
                    break;
                case 11:
                    // TODO: 27/02/16
                    break;
                case 12:
                    // TODO: 27/02/16
                    break;
                case 15:
                    // TODO: 27/02/16
                    break;
                case 14:
                    // TODO: 27/02/16
                    break;
                default:
                    break;
            }
        } while(opt != 0);


        System.out.println("\nExecution stopped");
        input.close();

    }

}
