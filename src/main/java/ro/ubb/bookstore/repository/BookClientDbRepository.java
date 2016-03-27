package main.java.ro.ubb.bookstore.repository;

import com.sun.corba.se.spi.activation.Repository;
import main.java.ro.ubb.bookstore.domain.Book;
import main.java.ro.ubb.bookstore.domain.BookClient;
import main.java.ro.ubb.bookstore.domain.Client;
import main.java.ro.ubb.bookstore.domain.Validators.Validator;
import main.java.ro.ubb.bookstore.domain.Validators.ValidatorException;

import java.sql.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * Created by robertszekely on 28/03/16.
 */
public class BookClientDbRepository implements IRepository<Long, BookClient> {

    private String url;
    private String password;
    private String username;
    private Validator<Long, BookClient> validator;

    public BookClientDbRepository(String url, String username, String password, Validator<Long, BookClient> validator) {
        this.url = url;
        this.password  = password;
        this.username = username;
        this.validator = validator;
    }


    @Override
    public Optional<BookClient> findOne(Long aLong) {
        return null;
    }

    @Override
    public Iterable<BookClient> findAll() {
        Set<BookClient> bookclients = new HashSet<>();
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM bookclient");
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                long bookid = resultSet.getLong("bookid");
                long clientid = resultSet.getLong("clientid");

                Book book = new Book();
                try (Connection connection1 = DriverManager.getConnection(url, username, password);
                        PreparedStatement statement1 = connection1.prepareStatement("SELECT * from book WHERE bookid=?")) {
                        statement1.setLong(1, bookid);
                    try (ResultSet resultSet1 = statement1.executeQuery()) {
                        if(resultSet1.next()) {
                            Long bookid1 = resultSet1.getLong("bookid");
                            String title = resultSet1.getString("title");
                            String author = resultSet1.getString("author");
                            String category = resultSet1.getString("category");
                            Float price = resultSet1.getFloat("price");

                            book.setTitle(title);
                            book.setAuthor(author);
                            book.setCategory(category);
                            book.setPrice(price);
                            book.setId(bookid1);
                        }
                    }
                }
                Client client = new Client();
                try (Connection connection2 = DriverManager.getConnection(url, username, password);
                        PreparedStatement statement2 = connection2.prepareStatement("SELECT * FROM client WHERE clientid=?")) {
                        statement2.setLong(1, clientid);
                    try(ResultSet resultSet2 = statement2.executeQuery()) {
                        if (resultSet2.next()) {
                            Long cid = resultSet2.getLong("clientid");
                            String firstname = resultSet2.getString("firstname");
                            String lastname = resultSet2.getString("lastname");
                            String email = resultSet2.getString("email");
                            String telephone = resultSet2.getString("telephone");

                            client.setFirstName(firstname);
                            client.setLastName(lastname);
                            client.setEmail(email);
                            client.setTelephone(telephone);
                            client.setId(cid);
                        }
                    }
                }
                BookClient bookClient = new BookClient(book, client);
                bookclients.add(bookClient);

            }
            return bookclients;


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Optional<BookClient> save(BookClient entity) throws ValidatorException {
        return null;
    }

    @Override
    public Optional<BookClient> delete(Long aLong) {
        return null;
    }

    @Override
    public Optional<BookClient> update(BookClient entity) throws ValidatorException {
        return null;
    }
}
