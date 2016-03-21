package main.java.ro.ubb.bookstore.repository;

import main.java.ro.ubb.bookstore.domain.Book;
import main.java.ro.ubb.bookstore.domain.Validators.Validator;
import main.java.ro.ubb.bookstore.domain.Validators.ValidatorException;
import main.java.ro.ubb.bookstore.util.XmlBookReader;
import main.java.ro.ubb.bookstore.util.XmlBookWriter;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

/**
 * Created by Bianca on 20/03/2016.
 */
public class BookXmlRepository extends InMemoryRepository<Long, Book> {
    private String fileName;

    public BookXmlRepository(Validator<Book> validator, String fileName) {
        super(validator);
        this.fileName = fileName;

        try {
            loadData();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    private void loadData() throws IOException, SAXException, ParserConfigurationException {
        List<Book> books = new XmlBookReader(fileName).loadEntities();

        for (Book book : books) {
            try {
                super.save(book);
            } catch (ValidatorException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Optional<Book> save(Book entity) throws ValidatorException {
        Optional<Book> optional = super.save(entity);
        if (optional.isPresent()) {
            return optional;
        }

        try {
            new XmlBookWriter(fileName).saveData(entity);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }
}
