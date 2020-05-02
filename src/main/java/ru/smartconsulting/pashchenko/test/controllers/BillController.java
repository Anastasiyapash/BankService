package ru.smartconsulting.pashchenko.test.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.smartconsulting.pashchenko.test.RepositoryUtils;
import ru.smartconsulting.pashchenko.test.entities.Bill;
import ru.smartconsulting.pashchenko.test.interfaces.BillRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BillController {
    @Autowired
    private BillRepository billRepository;
    RepositoryUtils repositoryUtils = new RepositoryUtils();
    @RequestMapping("/getBill")
    public List<Bill> getBill() {
        repositoryUtils.setBillRep(billRepository);
        List<Bill> billList = new ArrayList<Bill>();
        billList.addAll(repositoryUtils.findAllByBill());
        return billList;
    }
}