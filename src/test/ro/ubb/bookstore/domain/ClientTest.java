package test.ro.ubb.bookstore.domain;

import main.java.ro.ubb.bookstore.domain.Client;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by robertszekely on 13/03/16.
 */
public class ClientTest {
    private static final Long ID = new Long(1);
    private static final Long NEW_ID = new Long(2);
    private static String FIRSTNAME = "fn01";
    private static String NEW_FIRSTNAME = "fn02";
    private static String LASTNAME = "ln01";
    private static String NEW_LASTNAME = "ln02";
    private static String EMAIL = "em01";
    private static String NEW_EMAIL = "em02";
    private static String TELEPHONE = "tel01";
    private static String NEW_TELEPHONE = "tel02";

    private Client client;

    @Before
    public void setUp() throws Exception {
        client = new Client(FIRSTNAME, LASTNAME, EMAIL, TELEPHONE);
        client.setId(ID);
    }

    @After
    public void tearDown() throws Exception {
        client = null;
    }

    @Test
    public void testGetFirstName() throws Exception {
        assertEquals("First name should be equal", FIRSTNAME, client.getFirstName());
    }
    @Test
    public void testSetFirstName() throws Exception {
        client.setFirstName(NEW_FIRSTNAME);
        assertEquals("First name should be equal", NEW_FIRSTNAME, client.getFirstName());
    }

    @Test
    public void testGetLastName() throws Exception {
        assertEquals("Last name should be equal", LASTNAME, client.getLastName());
    }

    @Test
    public void testSetLasttName() throws Exception {
        client.setLastName(NEW_LASTNAME);
        assertEquals("Last name should be equal", NEW_LASTNAME, client.getLastName());
    }

    @Test
    public void testGetEmail() throws Exception {
        assertEquals("Email should be equal", EMAIL, client.getEmail());
    }
    @Test
    public void testSetEmail() throws Exception {
        client.setEmail(NEW_EMAIL);
        assertEquals("Email should be equal", NEW_EMAIL, client.getEmail());
    }

    @Test
    public void testGetTelephone() throws Exception {
        assertEquals("Telephone should be equal", TELEPHONE, client.getTelephone());
    }
    @Test
    public void testSetTelephone() throws Exception {
        client.setTelephone(NEW_TELEPHONE);
        assertEquals("Telephone should be equal", NEW_TELEPHONE, client.getTelephone());
    }
}
