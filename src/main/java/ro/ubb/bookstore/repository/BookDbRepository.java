package main.java.ro.ubb.bookstore.repository;

import main.java.ro.ubb.bookstore.domain.Book;
import main.java.ro.ubb.bookstore.domain.Validators.Validator;
import main.java.ro.ubb.bookstore.domain.Validators.ValidatorException;

import java.sql.*;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * Created by robertszekely on 26/03/16.
 */
public class BookDbRepository implements IRepository<Long, Book> {

    private String url;
    private String username;
    private String password;
    private Validator<Book> validator;

    public BookDbRepository(String url, String username, String password, Validator<Book> validator) {
        this.url = url;
        this.username = username;
        this.password = password;
        this.validator = validator;
    }

    @Override
    public Optional<Book> findOne(Long id) {
        //TODO

        return Optional.empty();
    }


    @Override
    public Iterable<Book> findAll() {
        Set<Book> books = new HashSet<>();
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM Book");
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Long id = resultSet.getLong("BookID");
                String title = resultSet.getString("Title");
                String author = resultSet.getString("Author");
                String category = resultSet.getString("Category");
                Float price = resultSet.getFloat("Price");

                Book book = new Book(title, author, category, price);
                book.setId(id);
                books.add(book);
            }
            return books;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    @Override
    public Optional<Book> save (Book entity) throws ValidatorException {
        //TODO

        return Optional.of(entity);
    }

    @Override
    public  Optional<Book> delete(Long id) {
        //TODO

        Optional<Book> books = findOne(id);

        return books;
    }

    @Override
    public Optional<Book> update (Book entity) throws ValidatorException {
        //TODO

        return Optional.of(entity);
    }


}
