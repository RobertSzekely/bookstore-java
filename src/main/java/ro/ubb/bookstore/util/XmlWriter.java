package main.java.ro.ubb.bookstore.util;

import main.java.ro.ubb.bookstore.domain.BaseEntity;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

/**
 * Created by Bianca on 20/03/2016.
 */
public abstract class XmlWriter <ID, T extends BaseEntity<ID>> {

    private String fileName;

    public XmlWriter() {}

    public XmlWriter(String fileName) {
        this.fileName = fileName;
    }

    public abstract void saveData(T entity) throws ParserConfigurationException, IOException, SAXException, TransformerException;

}