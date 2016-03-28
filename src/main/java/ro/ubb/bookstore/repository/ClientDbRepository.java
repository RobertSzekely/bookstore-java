package main.java.ro.ubb.bookstore.repository;


import main.java.ro.ubb.bookstore.domain.Client;
import main.java.ro.ubb.bookstore.domain.Validators.Validator;
import main.java.ro.ubb.bookstore.domain.Validators.ValidatorException;


import java.sql.*;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class ClientDbRepository implements IRepository<Long, Client> {

    private String url;
    private String username;
    private String password;
    private Validator<Long, Client> validator;

    public ClientDbRepository(String url, String username, String password, Validator<Long, Client> validator){
        this.url = url;
        this.username = username;
        this.password = password;
        this.validator = validator;
    }

    @Override
    public Optional<Client> findOne(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Id must not be null");
        }

        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = connection.prepareStatement("Select * from client where clientid=?")) {
            statement.setLong(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Long clientid = resultSet.getLong("clientid");
                    String firstName = resultSet.getString("fisrtName");
                    String lastName = resultSet.getString("lastName");
                    String email = resultSet.getString("email");
                    String telephone = resultSet.getString("telephone");

                    Client client = new Client(firstName, lastName, email, telephone);
                    client.setId(clientid);
                    return Optional.of(client);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return Optional.empty();


    }

    @Override
    public Iterable<Client> findAll(){
        Set<Client> clients = new HashSet<>();
        try (Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connection.prepareStatement("Select * from client");
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Long id = resultSet.getLong("ClientID");
                String firstName = resultSet.getString("FirstName");
                String lastName = resultSet.getString("LastName");
                String email = resultSet.getString("Email");
                String telephone = resultSet.getString("Telephone");

                Client client = new Client(firstName, lastName, email, telephone);
                client.setId(id);
                clients.add(client);
            }
            return clients;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return clients;
    }

    @Override
    public Optional<Client> save (Client entity) throws ValidatorException {
        if (entity == null) {
            throw new IllegalArgumentException("enity must not be null");
        }
        validator.validate(entity);

        try (Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connection.prepareStatement("Insert into client (clientid, firstName, lastName, email, telephone) values (?,?,?,?,?)")) {

            statement.setLong(1, entity.getId());
            statement.setString(2, entity.getFirstName());
            statement.setString(3, entity.getLastName());
            statement.setString(4, entity.getEmail());
            statement.setString(5, entity.getTelephone());

            statement.executeQuery();

            return Optional.empty();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.of(entity);
    }


    @Override
    public Optional<Client> delete(Long id) {
        if (id == null) {
            throw  new IllegalArgumentException("id must not be null");
        }
        Optional<Client> client = findOne(id);

        try (Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connection.prepareStatement("Delete from client where clientid=?")) {
            statement.setLong(1, id);

            statement.executeUpdate();
            return Optional.empty();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return client;
    }

    @Override
    public Optional<Client> update (Client entity) throws  ValidatorException {
        if (entity == null) {
            throw  new IllegalArgumentException("entity must not be null");
        }

        validator.validate(entity);

        try (Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connection.prepareStatement("Update client set firstName=?, lastName=?, email=?, telephone=? where clientid=?")){
            statement.setString(1, entity.getFirstName());
            statement.setString(2, entity.getLastName());
            statement.setString(3, entity.getEmail());
            statement.setString(4, entity.getTelephone());
            statement.setLong(5, entity.getId());

            statement.executeUpdate();
            return Optional.empty();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.of(entity);
    }

    public long getBiggestID () {
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM client WHERE clientid=(SELECT MAX (clientid) FROM client)")) {
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Long clientid = resultSet.getLong("clientid");
                    return clientid;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

}
