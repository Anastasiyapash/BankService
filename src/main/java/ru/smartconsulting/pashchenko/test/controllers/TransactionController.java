package ru.smartconsulting.pashchenko.test.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.smartconsulting.pashchenko.test.RepositoryUtils;
import ru.smartconsulting.pashchenko.test.entities.Transaction;
import ru.smartconsulting.pashchenko.test.interfaces.TransactionRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TransactionController {
    @Autowired
    private TransactionRepository transactionRepository;

    RepositoryUtils repositoryUtils = new RepositoryUtils();

    @RequestMapping("/transactions")
    public List<Transaction> getTrans() {
        repositoryUtils.setRep(transactionRepository);
        return repositoryUtils.findAllTransactions();
    }
}
