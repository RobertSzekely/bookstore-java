package main.java.ro.ubb.bookstore.ui;

import main.java.ro.ubb.bookstore.controller.BookClientController;
import main.java.ro.ubb.bookstore.controller.BookController;
import main.java.ro.ubb.bookstore.controller.ClientController;
import main.java.ro.ubb.bookstore.domain.Book;
import main.java.ro.ubb.bookstore.domain.BookClient;
import main.java.ro.ubb.bookstore.domain.Client;
import main.java.ro.ubb.bookstore.domain.Validators.Validator;
import main.java.ro.ubb.bookstore.domain.Validators.ValidatorException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by robertszekely on 27/02/16.
 */
public class Console {
    private BookController bookController;
    private ClientController clientController;
    private BookClientController bookClientController;

    Scanner input  = new Scanner(System.in).useDelimiter("\n");

    public Console(BookController _bookController, ClientController _clientController, BookClientController _bookClientController) {
        this.bookController = _bookController;
        this.clientController = _clientController;
        this.bookClientController = _bookClientController;
    }

    public void runConsole() {
        //printMainMenu();
        //addBook();
        //printAllBooks();
        //addSomeBooks();
        //addSomeClients();
        //addBookClients();
        mainMenu();
    }

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

    private void addSomeClients() {
        Client client1 = new Client("Marius", "Farcas", "marius@gmail.com", "123");
        long id1 = 1;
        client1.setId(id1);

        Client client2 = new Client("Robert", "Szekely", "robibobi@yahoo.ro", "074sterge");
        long id2 = 2;
        client2.setId(id2);

        Client client3 = new Client("Sergiu", "Sima", "sebi@gmail.com", "cantbecontacted");
        long id3 = 3;
        client3.setId(id3);

        Client client4 = new Client("2Anca", "Sfiriac", "whatever@gmail.com", "youwish");
        long id4 = 4;
        client4.setId(id4);

        try {
            clientController.addClient(client1);
            clientController.addClient(client2);
            clientController.addClient(client3);
            clientController.addClient(client4);
        } catch (ValidatorException ex) {
            ex.printStackTrace();
        }
    }

    private void addBookClients() {
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

        Client client1 = new Client("Marius", "Farcas", "marius@gmail.com", "123");
        long id5 = 1;
        client1.setId(id5);

        Client client2 = new Client("Robert", "Szekely", "robibobi@yahoo.ro", "074sterge");
        long id6 = 2;
        client2.setId(id6);

        Client client3 = new Client("Sergiu", "Sima", "sebi@gmail.com", "cantbecontacted");
        long id7 = 3;
        client3.setId(id7);

        Client client4 = new Client("2Anca", "Sfiriac", "whatever@gmail.com", "youwish");
        long id8 = 4;
        client4.setId(id8);

        BookClient bc1 = new BookClient(book1, client2);
        long idd1 = 1;
        bc1.setId(idd1);

        BookClient bc2 = new BookClient(book2, client1);
        long idd2 = 2;
        bc2.setId(idd2);

        BookClient bc3 = new BookClient(book3, client4);
        long idd3 = 3;
        bc3.setId(idd3);

        BookClient bc4 = new BookClient(book4, client3);
        long idd4 = 4;
        bc4.setId(idd4);

        BookClient bc5 = new BookClient(book4, client2);
        long idd5 = 5;
        bc5.setId(idd5);

        try {
            bookClientController.addBookClient(bc1);
            bookClientController.addBookClient(bc2);
            bookClientController.addBookClient(bc3);
            bookClientController.addBookClient(bc4);
            bookClientController.addBookClient(bc5);
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
                + "(14) Sort clients by total money spent\n"
                + "(15) Print list of books bought by clients\n"
        );

    }


    // -----------------Books Stuff ---------------------------------

    private Book readBook() {
        System.out.println("Read book {id, title, author, category, price}");

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            Long id = Long.valueOf(bufferedReader.readLine());
            String title = bufferedReader.readLine();
            String author = bufferedReader.readLine();
            String category = bufferedReader.readLine();
            Float price = Float.valueOf(bufferedReader.readLine());

            Book book = new Book(title, author, category, price);
            //book.setId(book.getNrOfBooks());
            book.setId(id);
            return book;

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;

    }

    private Long readId() {
        System.out.println("Enter id: ");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            return Long.valueOf(bufferedReader.readLine());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
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

    private String readTitle() {
        System.out.println("Enter title: ");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            return bufferedReader.readLine();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    private Float readPrice() {
        System.out.println("Enter price: ");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            return Float.valueOf(bufferedReader.readLine());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
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

    private void filterBooksByAuthor() {
        String author = readAuthor();
        Set<Book> books = bookController.filterBooksByAuthor(author);
        books.stream().forEach(System.out::println);
    }

    private void filterBooksByTitle() {
        String title = readTitle();
        Set<Book> books = bookController.filterBooksByTitle(title);
        books.stream().forEach(System.out::println);
    }

    private void filterBooksByPrice() {
        Float lowerBound = readPrice();
        Float upperBound = readPrice();
        Set<Book> books = bookController.filterBooksByPrice(lowerBound, upperBound);
        books.stream().forEach(System.out::println);
    }

    // -------------------Clients Stuff ---------------------------

    private Client readClient() {
        System.out.println("Read client {id, first name, last name, email, telephone}");

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        try {
            Long id = Long.valueOf(bufferedReader.readLine());
            String firstName = bufferedReader.readLine();
            String lastName = bufferedReader.readLine();
            String email = bufferedReader.readLine();
            String telephone = bufferedReader.readLine();

            Client client = new Client(firstName, lastName, email, telephone);
            client.setId(id);

            return client;

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;

    }

    private String readLastName() {
        System.out.println("Enter last name: ");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            return bufferedReader.readLine();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public void printAllClients() {
        Set<Client> clients = clientController.getAllClients();
        clients.stream().forEach(System.out::println);
    }

    private void addClient() {
        Client client = readClient();

        try {
            clientController.addClient(client);
        } catch (ValidatorException e) {
            e.printStackTrace();
        }

    }

    private void deleteClient() {
        try {
            long id = readId();
            clientController.deleteClient(id);
        } catch (NullPointerException ex) {
            ex.printStackTrace();
        }

    }

    private void updateClient() {
        Client client = readClient();
        try {
            clientController.updateClient(client);
        } catch (ValidatorException e) {
            e.printStackTrace();
        }
    }

    private void filterClientsByLastName() {
        String lastName = readLastName();
        Set<Client> clients = clientController.filterClientsByLastName(lastName);
        clients.stream().forEach(System.out::println);
    }

    private void printAllBookClients() {
        Set<BookClient> bookClients = bookClientController.getAllBookClients();
        bookClients.stream().forEach(System.out::println);
    }

//    private void buyBook() {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        Long id = null;
//
//        try {
//            id = Long.valueOf(bufferedReader.readLine());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        Client client = readClient();
//        Book book = readBook();
//
//        if (!bookController.checkExistance(book)) {
//            System.out.println("Book is not available.");
//        }
//        else {
//
//            try {
//                clientController.addClient(client);
//            } catch (ValidatorException e) {
//                e.printStackTrace();
//            }
//
//            BookClient bc = new BookClient(book, client);
//            bc.setId(id);
//
//            try {
//                bookClientController.addBookClient(bc);
//            } catch (ValidatorException e) {
//                e.printStackTrace();
//            }
//        }
//    }
    private Long readBookId() {
        System.out.println("Enter book id: ");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            return Long.valueOf(bufferedReader.readLine());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;

    }
    private Long readClientkId() {
        System.out.println("Enter client id: ");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            return Long.valueOf(bufferedReader.readLine());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;

    }
    private void buyBook() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int confirm=0;
        Book book = null;
        Client client = null;
        boolean condition;
        do {

            Long clientid = readClientkId();
            client = clientController.getClientByID(clientid);

            Long bookid = readBookId();
            book = bookController.getBookByID(bookid);


            System.out.print("Client: "+ client.getFirstName() + " " +client.getLastName() + "\n");
            System.out.print("Book: " +book.getTitle() + " by "+ book.getAuthor() +"\n");

            System.out.print("Confirm? (1 = YES / 0 = NO)");

            try {
                confirm = Integer.valueOf(bufferedReader.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (confirm == 1) {
                condition = false;
            } else {
                condition = true;
            }

        } while (condition);

        if (!bookController.checkExistance(book)) {
            System.out.println("Book is not available.");
        }
        else {

            try {
                clientController.addClient(client);
            } catch (ValidatorException e) {
                e.printStackTrace();
            }

            BookClient bc = new BookClient(book, client);
            //bc.setId(id);

            try {
                bookClientController.addBookClient(bc);
            } catch (ValidatorException e) {
                e.printStackTrace();
            }
        }


    }

    private void sortClients() {
        Set<BookClient> bookClients = bookClientController.getAllBookClients();
        Map<Long, Float> sortedClients = new HashMap<>();

        for (BookClient bc : bookClients) {
            if (!sortedClients.containsKey(bc.getClient().getId())) {
                sortedClients.put(bc.getClient().getId(), bc.getBook().getPrice());
            }
            else {
                Float price = sortedClients.get(bc.getClient().getId());
                Float price2 = price + bc.getBook().getPrice();
                sortedClients.replace(bc.getClient().getId(), price, price2);
            }
        }
        sortedClients.entrySet().stream()
                .sorted(Map.Entry.<Long, Float>comparingByValue().reversed())
                .limit(10)
                .forEach(System.out::println);

        /*
        sortedClients.forEach((k,v)->{
            System.out.println("Item : " + clientController.getClientByID(k) + " Count : " + v);
        });

        */
        //System.out.println(sortedClients.toString());
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
                    filterBooksByTitle();
                    break;
                case 6:
                    filterBooksByAuthor();
                case 7:
                    filterBooksByPrice();
                    break;
                case 8:
                    printAllClients();
                    break;
                case 9:
                    buyBook();
                    break;
                case 10:
                    addClient();
                    break;
                case 11:
                    deleteClient();
                    break;
                case 12:
                    updateClient();
                    break;
                case 13:
                    filterClientsByLastName();
                    break;
                case 14:
                    sortClients();
                    break;
                case 15:
                    printAllBookClients();
                default:
                    break;
            }
        } while(opt != 0);


        System.out.println("\nExecution stopped");
        input.close();

    }



}
