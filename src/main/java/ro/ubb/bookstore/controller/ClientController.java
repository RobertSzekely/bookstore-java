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

    public void addClient(Client client) throws ValidatorException {
        IRepository.save(client);
    }

    public void  deleteClient(long id) throws IllegalArgumentException {
        IRepository.delete(id);
    }

    public void updateClient(Client client) throws ValidatorException {
        IRepository.update(client);
    }

    public Set<Client> filterClientsByLastName(String s) {
        Iterable<Client> clients = IRepository.findAll();

        Set<Client> filteredClients = new HashSet<>();
        clients.forEach(filteredClients::add);
        filteredClients.removeIf(client -> !client.getLastName().contains(s));

        return filteredClients;
    }

    public Set<Client> getAllClients() {
        Iterable<Client> clients = IRepository.findAll();
        return StreamSupport.stream(clients.spliterator(), false).collect(Collectors.toSet());
    }
}
