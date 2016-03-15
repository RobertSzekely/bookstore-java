package main.java.ro.ubb.bookstore.controller;

import main.java.ro.ubb.bookstore.domain.Client;
import main.java.ro.ubb.bookstore.domain.Validators.ValidatorException;
import main.java.ro.ubb.bookstore.repository.IRepository;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Created by robertszekely on 07/03/16.
 */
public class ClientController {
    private IRepository<Long, Client> IRepository;

    public ClientController(IRepository<Long, Client> IRepository) {
        this.IRepository = IRepository;
    }

    /**
     * Adds a client to the repository
     *
     * @param client
     * @return
     */
    public void addClient(Client client) throws ValidatorException {
        IRepository.save(client);
    }

    /**
     * Deletes a client from the
     *
     * @param id
     */
    public void  deleteClient(long id) throws IllegalArgumentException {
        IRepository.delete(id);
    }
    /**
     * Updates a client in the repository.
     *
     * @param client
     */
    public void updateClient(Client client) throws ValidatorException {
        IRepository.update(client);
    }

    /**
     * Returns all clients whose last name  contain the given string.
     *
     * @param s
     */
    public Set<Client> filterClientsByLastName(String s) {
        Iterable<Client> clients = IRepository.findAll();

        Set<Client> filteredClients = new HashSet<>();
        clients.forEach(filteredClients::add);
        filteredClients.removeIf(client -> !client.getLastName().contains(s));

        return filteredClients;
    }
    /**
     * Returns all clients from the repository.
     *
     * @return
     */
    public Set<Client> getAllClients() {
        Iterable<Client> clients = IRepository.findAll();
        return StreamSupport.stream(clients.spliterator(), false).collect(Collectors.toSet());
    }
}
