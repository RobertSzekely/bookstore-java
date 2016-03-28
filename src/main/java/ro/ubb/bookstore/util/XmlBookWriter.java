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
import java.io.IOException;

/**
 * Created by Bianca on 20/03/2016.
 */
public class XmlBookWriter extends XmlWriter<Long, Book> {

    private String fileName;

    public XmlBookWriter(String fileName) {
        super(fileName);
        this.fileName = fileName;
    }

    @Override
    public void saveData(Book entity)
            throws ParserConfigurationException, IOException, SAXException, TransformerException {

        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(fileName);

        Node root = document.getDocumentElement();

        Node bookNode = document.createElement("book");
        root.appendChild(bookNode);

        Attr categoryAttribute = document.createAttribute("category");
        categoryAttribute.setValue(entity.getCategory());
        ((Element) bookNode).setAttributeNode(categoryAttribute);

        appendChildElement(document, bookNode, "id", String.valueOf(entity.getId()));
        appendChildElement(document, bookNode, "title", entity.getTitle());
        appendChildElement(document, bookNode, "author", entity.getAuthor());
        appendChildElement(document, bookNode, "price", String.valueOf(entity.getPrice()));

        Transformer transformerFactory = TransformerFactory.newInstance().newTransformer();
        DOMSource domSource = new DOMSource(document);
        Result result = new StreamResult(fileName);
        transformerFactory.transform(domSource, result);
    }

    private static void appendChildElement(Document document, Node bookNode, String tagName, String textContent) {
        Node titleNode = document.createElement(tagName);
        titleNode.setTextContent(textContent);
        bookNode.appendChild(titleNode);
    }

}

