package main.java.ro.ubb.bookstore.domain;

/**
 * Created by robertszekely on 27/02/16.
 */
public class Book extends BaseEntity<Long> {
    private String ISBN;
    private String title;
    private String author;
    private float price;

    public Book() { }

    //toodo Modifications on branch develop
    //Constructor (id is automatically assigned to each book)
    public Book(String _ISBN, String _title, String _author, float _price) {
        this.ISBN = _ISBN;
        this.title = _title;
        this.author = _author;
        this.price = _price;
    }

    /*-------------------Getters--------------------------*/

    public String getISBN() {
        return this.ISBN;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public float getPrice() {
        return price;
    }


    /*---------------------Setters----------------------------*/

    public void setISBN(String new_ISBN) {
        this.ISBN = new_ISBN;
    }

    public void setTitle(String new_title) {
        this.title = new_title;
    }

    public void setAuthor (String new_author) {
        this.author = new_author;
    }

    public void setPrice(float new_price) {
        this.price = new_price;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if(ISBN != book.ISBN) return false;
        if(title != book.title) return false;
        if(author != book.author) return false;
        if(price != book.price) return false;
        return title.equals(book.title);

    }

    @Override
    public String toString() {
        return "Book{" +
                "ISBN='" + ISBN + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", price='" + price +
                "} " + super.toString();
    }
}
