package ru.smartconsulting.pashchenko.test.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.smartconsulting.pashchenko.test.RepositoryUtils;
import ru.smartconsulting.pashchenko.test.entities.Bill;
import ru.smartconsulting.pashchenko.test.entities.Client;
import ru.smartconsulting.pashchenko.test.interfaces.BillRepository;
import ru.smartconsulting.pashchenko.test.interfaces.ClientRepository;
import ru.smartconsulting.pashchenko.test.interfaces.TransactionRepository;

import java.util.List;

@RestController
public class BillController {
    @Autowired
    private BillRepository billRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private TransactionRepository transactionRepository;
    RepositoryUtils repositoryUtils = new RepositoryUtils();

    @GetMapping("/bills/{id}")
    public Bill getById(@PathVariable("id") Integer id) {
        repositoryUtils.setRep(billRepository);
        return repositoryUtils.findBillById(id);
    }

    @GetMapping("/bills")
    public List<Bill> getBills() {
        repositoryUtils.setRep(billRepository);
        return repositoryUtils.findAllBills();
    }

    @GetMapping("/bills/client/{idClient}")
    public List<Bill> getByIdClient(@PathVariable("idClient") Integer idClient) {
        repositoryUtils.setRep(billRepository);
        return repositoryUtils.findBillsByIdClient(idClient);
    }

    @GetMapping("/bills/new/{idClient}/{countMoney}")
    public Bill newBill(@PathVariable("idClient") Integer idClient,
                           @PathVariable("countMoney") Integer countMoney){
        repositoryUtils.setRep(billRepository);
        return repositoryUtils.newBill(idClient, countMoney);
    }
}
