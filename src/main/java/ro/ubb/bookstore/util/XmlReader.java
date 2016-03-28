package main.java.ro.ubb.bookstore.util;

import main.java.ro.ubb.bookstore.domain.BaseEntity;
import main.java.ro.ubb.bookstore.domain.Book;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.List;

/**
 * Created by Bianca on 20/03/2016.
 */

public abstract class XmlReader<ID, T extends BaseEntity<ID>> {
    private String fileName;

    public XmlReader() { }

    public XmlReader(String fileName) {
        this.fileName = fileName;
    }

    public abstract List<T> loadEntities() throws ParserConfigurationException, IOException, SAXException;

    protected static String getNodeValue(Element bookNode, String nodeName) {
        NodeList nodeList = bookNode.getElementsByTagName(nodeName);
        Node node = nodeList.item(0);
        return node.getTextContent();
    }

}