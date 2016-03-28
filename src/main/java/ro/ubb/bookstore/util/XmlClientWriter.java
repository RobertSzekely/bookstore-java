package main.java.ro.ubb.bookstore.util;

import main.java.ro.ubb.bookstore.domain.Client;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.IOException;

/**
 * Created by Bianca on 21/03/2016.
 */

public class XmlClientWriter extends XmlWriter<Long, Client> {

    private String fileName;

    public XmlClientWriter(String fileName) {
        super(fileName);
        this.fileName = fileName;
    }

    @Override
    public void saveData(Client entity)
            throws ParserConfigurationException, IOException, SAXException, TransformerException {

        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(fileName);

        Node root = document.getDocumentElement();

        Node clientNode = document.createElement("client");
        root.appendChild(clientNode);

        Attr emailAttribute = document.createAttribute("email");
        emailAttribute.setValue(entity.getEmail());
        ((Element) clientNode).setAttributeNode(emailAttribute);

        appendChildElement(document, clientNode, "id", String.valueOf(entity.getId()));
        appendChildElement(document, clientNode, "firstName", entity.getFirstName());
        appendChildElement(document, clientNode, "lastName", entity.getLastName());
        appendChildElement(document, clientNode, "telephone", entity.getTelephone());

        Transformer transformerFactory = TransformerFactory.newInstance().newTransformer();
        DOMSource domSource = new DOMSource(document);
        javax.xml.transform.Result result = new StreamResult(fileName);
        transformerFactory.transform(domSource, result);
    }

    private static void appendChildElement(Document document, Node clientNode, String tagName, String textContent) {
        Node titleNode = document.createElement(tagName);
        titleNode.setTextContent(textContent);
        clientNode.appendChild(titleNode);
    }

}