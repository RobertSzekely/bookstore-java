package test.ro.ubb.bookstore.domain;

import main.java.ro.ubb.bookstore.domain.Book;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by robertszekely on 06/03/16.
 */
public class BookTest {
    private static final Long ID = new Long(1);
    private static final Long NEW_ID = new Long(2);
    private static final String ISBN = "isbn01";
    private static final String NEW_ISBN = "isbn02";
    private static final String TITLE = "title01";
    private static final String NEW_TITLE = "title02";
    private static final String AUTHOR = "author01";
    private static final String NEW_AUTHOR = "author02";
    private static final float PRICE = 10;
    private static final float NEW_PRICE = 12;
    private static final int UNITS = 5;
    private static final int NEW_UNITS = 6;


    private Book book;

    @Before
    public void setUp () throws Exception {
        book = new Book(ISBN, TITLE, AUTHOR, PRICE);
        book.setId(ID);
    }
    @After
    public void tearDown() throws Exception {
        book = null;
    }

    @Test
    public void testGetISBN() throws Exception {
        assertEquals("ISBN should be equal", ISBN, book.getISBN());
    }

    @Test
    public void testSetISBN() throws Exception {
        book.setISBN(NEW_ISBN);
        assertEquals("ISBN should be equal", NEW_ISBN, book.getISBN());
    }

    @Test
    public void testGetId() throws Exception {
        assertEquals("ID should be equal", ID, book.getId());
    }

    @Test
    public void testSetId() throws Exception {
        book.setId(NEW_ID);
        assertEquals("ID should be equal", NEW_ID, book.getId());
    }

    @Test
    public void testGetTitle() throws Exception {
        assertEquals("Title should be equal", TITLE, book.getTitle());
    }

    @Test
    public void testSetTitle() throws Exception {
        book.setTitle(NEW_TITLE);
        assertEquals("Title should be equal", NEW_TITLE, book.getTitle());
    }

    @Test
    public void testGetAuthor() throws Exception {
        assertEquals("Author should be equal", AUTHOR, book.getAuthor());
    }

    @Test
    public void testSetAuthor() throws Exception {
        book.setAuthor(NEW_AUTHOR);
        assertEquals("Author should be equal", NEW_AUTHOR, book.getAuthor());
    }

//    @Test
//    public void testGetPrice() throws Exception {
//        assertEquals("Title should be equal", PRICE, book.getPrice());
//    }
//
//    @Test
//    public void testSetPrice() throws Exception {
//        book.setPrice(NEW_PRICE;
//        assertEquals("Price should be equal", NEW_PRICE, book.getPrice());
//    }


}
