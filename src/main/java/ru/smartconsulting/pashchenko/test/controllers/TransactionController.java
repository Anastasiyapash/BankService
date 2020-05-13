package ru.smartconsulting.pashchenko.test.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.smartconsulting.pashchenko.test.RepositoryUtils;
import ru.smartconsulting.pashchenko.test.entities.Bill;
import ru.smartconsulting.pashchenko.test.entities.Transaction;
import ru.smartconsulting.pashchenko.test.interfaces.BillRepository;
import ru.smartconsulting.pashchenko.test.interfaces.ClientRepository;
import ru.smartconsulting.pashchenko.test.interfaces.TransactionRepository;

import java.util.List;

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

    @GetMapping("/transactions/new/{idBill}/{amount}")
    public Transaction getNewTransaction(@PathVariable("idBill") Integer idBill,
                                      @PathVariable("amount") Integer amount){
        repositoryUtils.setRep(transactionRepository);
        return repositoryUtils.newTransaction(idBill, amount);
    }
}
