package main.java.ro.ubb.bookstore.repository;

import main.java.ro.ubb.bookstore.domain.Client;
import main.java.ro.ubb.bookstore.domain.Validators.Validator;
import main.java.ro.ubb.bookstore.domain.Validators.ValidatorException;
import main.java.ro.ubb.bookstore.util.XmlClientReader;
import main.java.ro.ubb.bookstore.util.XmlClientWriter;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

/**
 * Created by Bianca on 21/03/2016.
 */

public class ClientXmlRepository extends InMemoryRepository<Long, Client> {
    private String fileName;

    public ClientXmlRepository(Validator<Long, Client> validator, String fileName) {
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
        List<Client> clients = new XmlClientReader(fileName).loadEntities();

        for (Client client : clients) {
            try {
                super.save(client);
            } catch (ValidatorException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Optional<Client> save(Client entity) throws ValidatorException {
        Optional<Client> optional = super.save(entity);
        if (optional.isPresent()) {
            return optional;
        }

        try {
            new XmlClientWriter(fileName).saveData(entity);
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
