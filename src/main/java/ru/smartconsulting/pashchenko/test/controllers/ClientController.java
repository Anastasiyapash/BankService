package ru.smartconsulting.pashchenko.test.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.smartconsulting.pashchenko.test.RepositoryUtils;
import ru.smartconsulting.pashchenko.test.entities.Client;
import ru.smartconsulting.pashchenko.test.interfaces.ClientRepository;

import java.security.SecureRandom;
import java.util.List;
import java.util.Map;


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

    @PostMapping("/clients")
    public Client newClient(@RequestBody Map<String, String> body) {
        repositoryUtils.setRep(clientRepository);
        String name = body.get("name");
        String address = body.get("address");
        Integer age = Integer.parseInt(body.get("age"));
        return repositoryUtils.newClient(name, address, age);
    }

    @GetMapping("/client/name/{name}")
    public Client getByName(@PathVariable("name") String name) {
        return repositoryUtils.findClientByName(name);
    }
}
