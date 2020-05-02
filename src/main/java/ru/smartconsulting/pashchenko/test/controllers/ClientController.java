package ru.smartconsulting.pashchenko.test.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.smartconsulting.pashchenko.test.RepositoryUtils;
import ru.smartconsulting.pashchenko.test.entities.Client;
import ru.smartconsulting.pashchenko.test.interfaces.ClientRepository;

import java.util.ArrayList;
import java.util.List;


@RestController
public class ClientController {
    @Autowired
    private ClientRepository clientRepository;

    RepositoryUtils repositoryUtils = new RepositoryUtils();

    @RequestMapping("/getClient")
    public List<Client> getName() {
        repositoryUtils.setRep(clientRepository);
        List<Client> clientList = new ArrayList<Client>();
        clientList.addAll(repositoryUtils.findAllByClient());
        return clientList;
    }

/*
    @RequestMapping("/getByNameClient{name}")
    public List<Client> getByName(){
        String name = "Ivan";
        repositoryUtils.setRep(clientRepository);
        List<Client> clientList = new ArrayList<Client>();
        clientList.addAll(repositoryUtils.findByName(name));
    }*/

}
