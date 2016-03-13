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
        addSomeBooks();
        mainMenu();
    }


    Scanner input  = new Scanner(System.in).useDelimiter("\n");

    private void addSomeBooks() {
        Book book1 = new Book("The Book Thief", "Zusak Markus", "Young Adult", 55);
        long id1 = 1;
        book1.setId(id1);

        Book book2 = new Book("The Darkest Minds", "Bracken Alexandra", "Dystopian", 34);
        long id2 = 2;
        book2.setId(id2);

        Book book3 = new Book("Harry Potter and The Philosopher's Stone", "J.K. Rowling", "Childern", 45);
        long id3 = 3;
        book3.setId(id3);

        Book book4 = new Book("The Perks of Being a Wallflower", "Stephen Chbosky", "Contemporary", 39);
        long id4 = 4;
        book4.setId(id4);

        try {
            bookController.addBook(book1);
            bookController.addBook(book2);
            bookController.addBook(book3);
            bookController.addBook(book4);
        } catch (ValidatorException ex) {
            ex.printStackTrace();
        }
    }

    public void printMainMenu() {
        System.out.println("\n(0) Exit\n"
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
    }

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
        System.out.println("Read book {id, title, author, category, price");

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            Long id = Long.valueOf(bufferedReader.readLine());
            String title = bufferedReader.readLine();
            String author = bufferedReader.readLine();
            String category = bufferedReader.readLine();
            Float price = Float.valueOf(bufferedReader.readLine());

            Book book = new Book(title, author, category, price);
            book.setId(id);

            return book;

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;

    }

    private Long readId() {
        System.out.println("Enter book id: ");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            return Long.valueOf(bufferedReader.readLine());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    private void deleteBook() {
        try {
            long id = readId();
            bookController.deleteBook(id);
        } catch (NullPointerException ex) {
            ex.printStackTrace();
        }

    }

    private void updateBook() {
        Book book = readBook();
        try {
            bookController.updateBook(book);
        } catch (ValidatorException e) {
            e.printStackTrace();
        }
    }

    private String readAuthor() {
        System.out.println("Enter author: ");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            return bufferedReader.readLine();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    private void filterBooksByAuthor() {
        String author = readAuthor();
        Set<Book> books = bookController.filterBooksByAuthor(author);
        books.stream().forEach(System.out::println);
    }



    private void mainMenu() {
        int opt;

        do {
            printMainMenu();
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
                    deleteBook();
                    break;
                case 4:
                    updateBook();
                    break;
                case 5:
                    // TODO: 27/02/16
                    break;
                case 6:
                    filterBooksByAuthor();
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
