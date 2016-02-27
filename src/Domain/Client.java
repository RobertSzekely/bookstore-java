package Domain;

/**
 * Created by robertszekely on 27/02/16.
 */
public class Client {

    private int id;
    private String CNP;
    private String firstName;
    private String lastName;
    private int numberOfClients = 0;

    //Constructor (id is automatically assigned by constructor)
    public Client(String _CNP, String _firstName, String _lastName) {
        this.id = ++numberOfClients;
        this.CNP = _CNP;
        this.firstName = _firstName;
        this.lastName = _lastName;
    }

    /*----------------------Getters-------------------------*/
    public String getCNP() {
        return CNP;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }

    /*-----------------------Setters---------------------------*/
    public void setCNP(String new_CNP) {
        this.CNP = new_CNP;
    }
    public void setFirstName(String new_firstName) {
        this.firstName = new_firstName;
    }
    public void setLastName (String new_lastName) {
        this.lastName = new_lastName;
    }
}
