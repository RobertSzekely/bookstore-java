package main.java.ro.ubb.bookstore.util;

import main.java.ro.ubb.bookstore.domain.Book;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Bianca on 20/03/2016.
 */
public class XmlBookReader extends XmlReader<Long, Book> {
    private String fileName;

    public XmlBookReader(String fileName) {
        super(fileName);
        this.fileName = fileName;
    }

    public List<Book> loadEntities() throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(fileName);

        Node root = document.getDocumentElement();
        NodeList nodeList = root.getChildNodes();
        List<Book> books = new ArrayList<>();

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);

            if (node instanceof Element) {
                Element element = (Element) node;
                Book book = createBook(element);
                books.add(book);
            }
        }
        return books;
    }

    private Book createBook(Element bookNode) {
        Attr attr = bookNode.getAttributeNode("category");
        String category = attr.getValue();

        String id = getNodeValue(bookNode, "id");
        String title = getNodeValue(bookNode, "title");
        String author = getNodeValue(bookNode, "author");
        String price = getNodeValue(bookNode, "price");

        Book book = new Book(title, author, category, Float.parseFloat(price));
        book.setId(Long.parseLong(id));
        return book;
    }

}
