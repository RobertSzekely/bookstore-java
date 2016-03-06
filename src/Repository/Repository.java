package Repository;

import Domain.Book;
import Domain.Client;

import java.util.List;

/**
 * Created by robertszekely on 27/02/16.
 */
public class Repository implements IRepository {


    private List<Book> booksList;
    private List<Client> clientsList;

    public Repository(List<Book> _booksListl, List<Client> _clientsList) {
        booksList = _booksListl;
        clientsList = _clientsList;

    }

    @Override
    public List<Book> getBookList() {
        return booksList;
    }

    @Override
    public List<Client> getClientList() {
        return clientsList;
    }


    @Override
    public void addClient(Client client) {

    }

    @Override
    public void addBook(Book book) {

    }
}
