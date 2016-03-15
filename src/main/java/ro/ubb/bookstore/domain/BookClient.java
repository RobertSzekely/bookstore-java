package main.java.ro.ubb.bookstore.domain;

/**
 * Created by Bianca on 13/03/2016.
 */
public class BookClient extends BaseEntity<Long> {
    Book book;
    Client client;

    // Constructor (id is automatically assigned by constructor)
    public BookClient(Book _book, Client _client) {
        this.book = _book;
        this.client = _client;
    }

    /*----------------------Getters-------------------------*/

    public Book getBook() { return book; }

    public Client getClient() { return client; }


    /*----------------------Setters-------------------------*/

    public void setBook(Book _book) { this.book = _book; }

    public void setClient(Client _client) { this.client = _client; }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookClient bc = (BookClient) o;

        if(!book.equals(bc.book)) return false;
        return client.equals(bc.client);
    }

    @Override
    public String toString() {
        return "Book :{" + book.toString() + "} \n" +
                "Client :{" + client.toString() + "} \n" + super.toString() + "\n";
    }
}
