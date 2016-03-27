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
        if (id == null) {
            throw new IllegalArgumentException("id must not be null");
        }
        try (Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement statement = connection.prepareStatement("SELECT * from book WHERE bookid=?")) {
            statement.setLong(1, id);
            try(ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Long bookid = resultSet.getLong("bookid");
                    String title = resultSet.getString("title");
                    String author = resultSet.getString("author");
                    String category = resultSet.getString("category");
                    Float price = resultSet.getFloat("price");


                    Book book = new Book(title, author, category, price);
                    book.setId(bookid);
                    return Optional.of(book);
                }
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }


    @Override
    public Iterable<Book> findAll() {
        Set<Book> books = new HashSet<>();
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM book");
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
        if(entity == null) {
            throw new IllegalArgumentException("entity must not be null");
        }
        //Validator.validate(entity);

        try (Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement statement = connection.prepareStatement("INSERT into book (bookid, title, author, category, price) VALUES (?,?,?,?,?)")) {

            statement.setLong(1, entity.getId());
            statement.setString(2, entity.getTitle());
            statement.setString(3, entity.getAuthor());
            statement.setString(4, entity.getCategory());
            statement.setFloat(5, entity.getPrice());

            statement.executeQuery();

            return Optional.empty();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.of(entity);
    }

    @Override
    public  Optional<Book> delete(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("id must not be null");
        }
        Optional<Book> book = findOne(id);

        try (Connection connection = DriverManager.getConnection(url, username, password);
                PreparedStatement statement = connection.prepareStatement("DELETE FROM book WHERE bookid=?")) {
            statement.setLong(1, id);

            statement.executeUpdate();

            return Optional.empty();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return book;
    }

    @Override
    public Optional<Book> update (Book entity) throws ValidatorException {
        //TODO

        return Optional.of(entity);
    }


}
