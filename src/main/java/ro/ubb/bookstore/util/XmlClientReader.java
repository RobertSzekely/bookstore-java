package main.java.ro.ubb.bookstore.util;

import main.java.ro.ubb.bookstore.domain.Client;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bianca on 21/03/2016.
 */

public class XmlClientReader extends XmlReader<Long, Client> {
    private String fileName;

    public XmlClientReader(String fileName) {
        super(fileName);
        this.fileName = fileName;
    }

    public List<Client> loadEntities() throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(fileName);

        Node root = document.getDocumentElement();
        NodeList nodeList = root.getChildNodes();
        List<Client> clients = new ArrayList<>();

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);

            if (node instanceof Element) {
                Element element = (Element) node;
                Client client = createClient(element);
                clients.add(client);
            }
        }
        return clients;
    }

    private Client createClient(Element clientNode) {
        Attr attr = clientNode.getAttributeNode("email");
        String email = attr.getValue();

        String id = getNodeValue(clientNode, "id");
        String firstName = getNodeValue(clientNode, "firstName");
        String lastName = getNodeValue(clientNode, "lastName");
        String telephone = getNodeValue(clientNode, "telephone");

        Client client = new Client(firstName, lastName, email, telephone);
        client.setId(Long.parseLong(id));
        return client;
    }

}