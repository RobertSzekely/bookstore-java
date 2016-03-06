package main.java.ro.ubb.bookstore.ui;

import main.java.ro.ubb.bookstore.controller.BookController;

import java.util.Scanner;

/**
 * Created by robertszekely on 27/02/16.
 */
public class Console {
    private BookController bookController;

    public Console(BookController bookController) {
        this.bookController = bookController;
    }

    public void runConsole() {
        printMainMenu();
    }


    Scanner input  = new Scanner(System.in).useDelimiter("\\n");;

    public void printMainMenu() {
        System.out.println("\nOptions for books:\n"
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

    public void printAddNewBook() {
        System.out.print("\nEnter ISBN: ");
        String isbn = input.next();
        System.out.print("\nEnter book title: ");
        String title = input.next();
        System.out.print("\nEnter book author: ");
        String author = input.next();
        // TODO: 27/02/16
    }

    public void printUpdateBook() {
        System.out.print("\nEnter ISBN: ");
        String isbn = input.next();
        System.out.print("\nEnter new book title: ");
        String title = input.next();
        System.out.print("\nEnter new book author: ");
        String author = input.next();
        // TODO: 27/02/16
    }
    public void printDeleteBook() {
        System.out.print("\nEnter ISBN: ");
        String isbn = input.next();
        // TODO: 27/02/16
    }


    public void printAddNewClient() {
        System.out.print("\nEnter CNP: ");
        String cnp = input.next();
        System.out.print("\nEnter first name: ");
        String firstname = input.next();
        System.out.print("\nEnter last name: ");
        String lastname = input.next();
        // TODO: 27/02/16
    }


    public void printDeleteClient() {
        System.out.print("\nEnter CNP: ");
        String cnp = input.next();
        // TODO: 27/02/16
    }

    public void printUpdateClient() {
        System.out.print("\nEnter CNP: ");
        String cnp = input.next();
        System.out.print("\nEnter new first name: ");
        String firstname = input.next();
        System.out.print("\nEnter new last name: ");
        String lastname = input.next();
        // TODO: 27/02/16
    }
}
