package Domain;

/**
 * Created by robertszekely on 27/02/16.
 */
public class Book {
    private int id;
    private String ISBN;
    private String title;
    private String author;
    private static int numberOfBooks = 0;

    //Constructor (id is automatically assigned to each book)
    public Book(String _ISBN, String _title, String _author) {
        this.id = ++numberOfBooks;
        this.ISBN = _ISBN;
        this.title = _title;
        this.author = _author;
    }

    /*-------------------Getters--------------------------*/
    public int getId() {
        return id;
    }

    public String getISBN() {
        return this.ISBN;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
    /*---------------------Setters----------------------------*/
    public void setId(int new_id) {
        this.id = new_id;
    }

    public void setISBN(String new_ISBN) {
        this.ISBN = new_ISBN;
    }

    public void setTitle(String new_title) {
        this.title = new_title;
    }

    public void setAuthor (String new_author) {
        this.author = new_author;
    }
}
