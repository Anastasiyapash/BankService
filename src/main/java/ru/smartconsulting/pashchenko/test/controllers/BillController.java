package ru.smartconsulting.pashchenko.test.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.smartconsulting.pashchenko.test.RepositoryUtils;
import ru.smartconsulting.pashchenko.test.entities.Bill;
import ru.smartconsulting.pashchenko.test.entities.Client;
import ru.smartconsulting.pashchenko.test.interfaces.BillRepository;
import ru.smartconsulting.pashchenko.test.interfaces.ClientRepository;
import ru.smartconsulting.pashchenko.test.interfaces.TransactionRepository;

import javax.validation.constraints.Null;
import java.util.List;
import java.util.Map;

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

    @PostMapping("/bills")
    public Bill newBill(@RequestBody Map<String, String> body) {
        repositoryUtils.setRep(billRepository);
        Integer idClient = Integer.parseInt(body.get("idClient"));
        if (repositoryUtils.findClientById(idClient) != null) {
            Integer countMoney = Integer.parseInt(body.get("countMoney"));
            return repositoryUtils.newBill(idClient, countMoney);
        } else {
            return null;
        }
    }

    @GetMapping("/bills/client/{idClient}")
    public List<Bill> getByIdClient(@PathVariable("idClient") Integer idClient) {
        repositoryUtils.setRep(billRepository);
        return repositoryUtils.findBillsByIdClient(idClient);
    }
}
