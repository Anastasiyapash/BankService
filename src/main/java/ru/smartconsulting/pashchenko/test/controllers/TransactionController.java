package ru.smartconsulting.pashchenko.test.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.smartconsulting.pashchenko.test.RepositoryUtils;
import ru.smartconsulting.pashchenko.test.entities.Bill;
import ru.smartconsulting.pashchenko.test.entities.Transaction;
import ru.smartconsulting.pashchenko.test.interfaces.BillRepository;
import ru.smartconsulting.pashchenko.test.interfaces.ClientRepository;
import ru.smartconsulting.pashchenko.test.interfaces.TransactionRepository;

import java.util.List;
import java.util.Map;

@RestController
public class TransactionController {
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private BillRepository billRepository;

    RepositoryUtils repositoryUtils = new RepositoryUtils();

    @GetMapping("/transactions/{id}")
    public Transaction getById(@PathVariable("id") Integer id) {
        repositoryUtils.setRep(transactionRepository);
        return repositoryUtils.findTransactionsById(id);
    }

    @GetMapping("/transactions")
    public List<Transaction> getTransactions() {
        repositoryUtils.setRep(transactionRepository);
        return repositoryUtils.findAllTransactions();
    }

    @PostMapping("/transactions")
    public Transaction newTransaction(@RequestBody Map<String, String> body) {
        repositoryUtils.setRep(transactionRepository);
        Integer idBill = Integer.parseInt(body.get("idBill"));
        if (!repositoryUtils.findTransactionsByIdBill(idBill).isEmpty()) {
            Integer amount = Integer.parseInt(body.get("amount"));
            return repositoryUtils.newTransaction(idBill, amount);
        } else {
            return null;
        }
    }

    @GetMapping("/transactions/bill/{idBill}")
    public List<Transaction> getByIdBill(@PathVariable("idBill") Integer idBill) {
        repositoryUtils.setRep(billRepository);
        repositoryUtils.setRep(transactionRepository);
        return repositoryUtils.findTransactionsByIdBill(idBill);
    }

    @GetMapping("/transactions/client/{idClient}")
    public List<Transaction> getByIdClient(@PathVariable("idClient") Integer idClient) {
        repositoryUtils.setRep(clientRepository);
        repositoryUtils.setRep(billRepository);
        repositoryUtils.setRep(transactionRepository);
        return repositoryUtils.findTransactionsByIdClient(idClient);
    }
}
