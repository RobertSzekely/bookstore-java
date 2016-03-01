package Domain;

/**
 * Created by robertszekely on 27/02/16.
 */
public class Book {
    private String ISBN;
    private String title;
    private String author;
    private float price;
    private int units;
    //Constructor (id is automatically assigned to each book)
    public Book(String _ISBN, String _title, String _author, float _price, int _units) {
        this.ISBN = _ISBN;
        this.title = _title;
        this.author = _author;
        this.price = _price;
        this.units = _units
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
    public int getUnits() {
        return units;
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
    public  void setUnits(int new_units) {
        this.units = new_units;
    }
}
