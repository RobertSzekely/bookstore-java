package main.java.ro.ubb.bookstore.domain;

/**
 * Created by Bianca on 13/03/2016.
 */
public class BookClient extends BaseEntity<Long> {
    Long bookID;
    Long clientID;

    // Constructor (id is automatically assigned by constructor)
    public BookClient(Long _bookID, Long _clientID) {
        this.bookID = _bookID;
        this.clientID = _clientID;
    }

    /*----------------------Getters-------------------------*/

    public Long getBookID() { return bookID; }

    public Long getClientID() { return clientID; }


    /*----------------------Setters-------------------------*/

    public void setBookID(Long _bookID) { this.bookID = _bookID; }

    public void setClientID(Long _clientID) { this.clientID = _clientID; }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookClient bc = (BookClient) o;

        if(bookID != bc.bookID) return false;
        return clientID.equals(bc.clientID);
    }

    @Override
    public String toString() {
        return "Book id:{" + bookID + "} " +
                "Client id:{" + clientID + "} " + super.toString();
    }
}
