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



//   public static void main(String[] args) {
//        System.out.println("Hello World!");
//        System.out.println("Hello from the other side!");
//        System.out.println("I think I'm starting to understand how this works....");


    public static void main(String [] args) {

        Scanner input  = new Scanner(System.in);
        Validator<Book> bookValidator = new BookValidator();
        IRepository<Long, Book> bookRepository = new InMemoryRepository<>(bookValidator);
        BookController bookController = new BookController(bookRepository);
        Console console = new Console(bookController);
        console.runConsole();


        int opt;

        do {
            console.printMainMenu();
            boolean cont = true;
            opt = 0;
            do {
                System.out.print("\nEnter option: ");
                opt = input.nextInt();
                cont = false;
            } while (cont == true);

            switch(opt) {
                case 1:
                    //// TODO: 27/02/16
                    break;
                case 2:
                    //// TODO: 27/02/16
                    console.printAddNewBook();
                    break;
                case 3:
                    console.printDeleteBook();
                    //// TODO: 27/02/16
                    break;
                case 4:
                    console.printUpdateBook();
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
                    console.printAddNewClient();
                    // TODO: 27/02/16
                    break;
                case 11:
                    console.printDeleteClient();
                    // TODO: 27/02/16
                    break;
                case 12:
                    console.printUpdateClient();
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

