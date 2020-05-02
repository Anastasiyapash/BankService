package ru.smartconsulting.pashchenko.test.controllers;

import lombok.experimental.PackagePrivate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.smartconsulting.pashchenko.test.RepositoryUtils;
import ru.smartconsulting.pashchenko.test.entities.Bill;
import ru.smartconsulting.pashchenko.test.entities.Client;
import ru.smartconsulting.pashchenko.test.entities.Transaction;
import ru.smartconsulting.pashchenko.test.interfaces.BillRepository;
import ru.smartconsulting.pashchenko.test.interfaces.ClientRepository;
import ru.smartconsulting.pashchenko.test.interfaces.TransactionRepository;

import java.util.ArrayList;
import java.util.List;


@RestController
public class ClientController {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private BillRepository billRepository;
    @Autowired
    private TransactionRepository transactionRepository;

    RepositoryUtils repositoryUtils = new RepositoryUtils();

    @RequestMapping("/getClient")
    public List<Client> getName() {
        repositoryUtils.setRep(clientRepository);
        List<Client> clientList = new ArrayList<Client>();
        clientList.addAll(repositoryUtils.findAllByClient());
        return clientList;
    }

    @RequestMapping("/getBill")
    public List<Bill> getBill() {
        repositoryUtils.setBillRep(billRepository);
        List<Bill> billList = new ArrayList<Bill>();
        billList.addAll(repositoryUtils.findAllByBill());
        return billList;
    }

    @RequestMapping("/getTrans")
    public List<Transaction> getTrans() {
        repositoryUtils.setTransRep(transactionRepository);
        List<Transaction> transactionList = new ArrayList<Transaction>();
        transactionList.addAll(repositoryUtils.findAllByTransaction());
        return transactionList;
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
