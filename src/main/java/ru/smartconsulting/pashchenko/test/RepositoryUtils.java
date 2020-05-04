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

    public RepositoryUtils() { }

    public List<Client> findAllClients() {
        return clientRepository.findAll();
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

    public List<Bill> findAllBills() {
        return billRepository.findAll();
    }

    public List<Bill> findBillsByIdClient(Integer idClient) {
        List<Bill> billList = billRepository.findAll();
        List<Bill> billsResult = new ArrayList<Bill>();
        for (Bill bills : billList) {
            if (bills.getIdClient() == idClient) {
                billsResult.add(bills);
            }
        }
        return billsResult;
    }

    public List<Transaction> findAllTransactions() {
        return transactionRepository.findAll();
    }

    public List<Transaction> findTransactionsByIdBill(Integer idBill) {
        List<Transaction> transactionsList = transactionRepository.findAll();
        List<Transaction> transactionsResult = new ArrayList<Transaction>();
        for (Transaction trans : transactionsList) {
            if (trans.getIdBill() == idBill) {
                transactionsResult.add(trans);
            }
        }
        return transactionsResult;
    }

    public List<Transaction> findTransactionsByIdClient(Integer idClient) {
        List<Transaction> transactionsResult = new ArrayList<Transaction>();
        List<Bill> billsClient = findBillsByIdClient(idClient);
        for (Bill bill : billsClient) {
            List<Transaction> transactions = findTransactionsByIdBill(bill.getIdBill());
            transactionsResult.addAll(transactions);
        }
        return transactionsResult;
    }

    public void setRep(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void setRep(BillRepository billRepository) {
        this.billRepository = billRepository;
    }

    public void setRep(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }
}
