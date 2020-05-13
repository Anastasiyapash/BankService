package ru.smartconsulting.pashchenko.test.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.smartconsulting.pashchenko.test.RepositoryUtils;
import ru.smartconsulting.pashchenko.test.entities.Client;
import ru.smartconsulting.pashchenko.test.interfaces.ClientRepository;

import java.util.List;


@RestController
public class ClientController {
    @Autowired
    private ClientRepository clientRepository;

    RepositoryUtils repositoryUtils = new RepositoryUtils();

    @GetMapping("/client/{id}")
    public Client getById(@PathVariable("id") Integer id) {
        repositoryUtils.setRep(clientRepository);
        return repositoryUtils.findClientById(id);
    }

    @GetMapping("/clients")
    public List<Client> getClients() {
        repositoryUtils.setRep(clientRepository);
        return repositoryUtils.findAllClients();
    }

    @GetMapping("/client/name/{name}")
    public Client getByName(@PathVariable("name") String name) {
        return repositoryUtils.findClientByName(name);
    }

    @GetMapping("/clients/new/{name}/{address}/{age}")
    public Client newClient(@PathVariable("name") String name,
                               @PathVariable("address") String address, @PathVariable("age") Integer age) {
        repositoryUtils.setRep(clientRepository);
        return repositoryUtils.newClient(name, address, age);
    }
}
