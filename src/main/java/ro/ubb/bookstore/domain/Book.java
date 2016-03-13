package main.java.ro.ubb.bookstore.domain;

/**
 * Created by robertszekely on 27/02/16.
 */
public class Book extends BaseEntity<Long> {
    private String title;
    private String author;
    private String category;
    private float price;

    public Book() { }

    //toodo Modifications on branch develop

    //Constructor (id is automatically assigned to each book)
    public Book(String _title, String _author, String _category, float _price) {
        this.title = _title;
        this.author = _author;
        this.category = _category;
        this.price = _price;
    }


    //commit me.
    /*-------------------Getters--------------------------*/


    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getCategory() {
        return category;
    }

    public float getPrice() {
        return price;
    }


    /*---------------------Setters----------------------------*/

    public void setTitle(String new_title) {
        this.title = new_title;
    }

    public void setAuthor (String new_author) {
        this.author = new_author;
    }

    private void setCategory (String new_category) {
        this.category = new_category;
    }

    public void setPrice(float new_price) {
        this.price = new_price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if(title != book.title) return false;
        if(author != book.author) return false;
        if(category != book.category) return false;
        if(price != book.price) return false;
        return title.equals(book.title);

    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", category='" + category + '\'' +
                ", price='" + price +
                "} " + super.toString();
    }
}
