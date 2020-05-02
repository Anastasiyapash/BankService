package ru.smartconsulting.pashchenko.test;

import org.springframework.stereotype.Repository;
import ru.smartconsulting.pashchenko.test.entities.Bill;
import ru.smartconsulting.pashchenko.test.entities.Client;
import ru.smartconsulting.pashchenko.test.entities.Transaction;
import ru.smartconsulting.pashchenko.test.interfaces.BillRepository;
import ru.smartconsulting.pashchenko.test.interfaces.ClientRepository;
import ru.smartconsulting.pashchenko.test.interfaces.TransactionRepository;

import java.util.ArrayList;
import java.util.List;

public class RepositoryUtils {
    ClientRepository clientRepository;
    BillRepository billRepository;
    TransactionRepository transactionRepository;

    public RepositoryUtils() {
    }

    public void setRep(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void setBillRep(BillRepository billRepository) {
        this.billRepository = billRepository;
    }

    public void setTransRep(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public List<Client> findAllByClient() {
        List<Client> clientsList = clientRepository.findAll();
        List<Client> allClients = new ArrayList<Client>();
        for (Client all : clientsList) {
            allClients.add(all);
        }
        return allClients;
    }

    public Client findClientByName(String name) {
        List<Client> clientsNameList = clientRepository.findAll();
        for (Client clientName : clientsNameList) {
            if (clientName.getName().equals(name)) {
                return clientName;
            }
        }
        return null;
    }

    public List<Bill> findAllByBill() {
        List<Bill> billList = billRepository.findAll();
        List<Bill> allBills = new ArrayList<Bill>();
        for (Bill all : billList) {
            allBills.add(all);
        }
        return allBills;
    }

    public List<Bill> findBillByIdClient(Integer idClient) {
        List<Bill> billList = billRepository.findAll();
        List<Bill> billsResult = new ArrayList<Bill>();
        for (Bill bills : billList) {
            if (bills.getIdClient() == idClient) {
                billsResult.add(bills);
            }
        }
        return billsResult;
    }

    public List<Transaction> findAllByTransaction() {
        List<Transaction> transactionList = transactionRepository.findAll();
        List<Transaction> allTransactions = new ArrayList<Transaction>();
        for (Transaction all : transactionList) {
            allTransactions.add(all);
        }
        return allTransactions;
    }

    public List<Transaction> findTransByIdBill(Integer idBill) {
        List<Transaction> transactionsBillList = transactionRepository.findAll();
        List<Transaction> transactionsResult = new ArrayList<Transaction>();
        for (Transaction trans : transactionsBillList) {
            if (trans.getIdBill() == idBill) {
                transactionsResult.add(trans);
            }
        }
        return transactionsResult;
    }

    public List<Transaction> findTransByIdClient(Integer idClient) {
        List<Transaction> transactionsResult = new ArrayList<Transaction>();
        List<Bill> billsClient = findBillByIdClient(idClient);
        for (Bill bill : billsClient) {
            List<Transaction> transactions = findTransByIdBill(bill.getIdBill());
            transactionsResult.addAll(transactions);
        }
        return transactionsResult;
    }

}
