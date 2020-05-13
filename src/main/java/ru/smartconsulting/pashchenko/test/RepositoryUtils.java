package ru.smartconsulting.pashchenko.test;

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

    public Client newClient(String name, String address, Integer age) {
        Client client = new Client(name, address, age);
        clientRepository.saveAndFlush(client);
        return client;
    }

    public Client findClientById(Integer id) {
        List<Client> clients = clientRepository.findAll();
        for (Client client : clients) {
            if (client.getId().equals(id)) {
                return client;
            }
        }
        return null;
    }

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

    public Bill newBill(Integer idClient, Integer countMoney){
        Bill bill = new Bill(idClient, countMoney);
        billRepository.saveAndFlush(bill);
        return bill;
    }

    public Bill findBillById(Integer id) {
        List<Bill> bills = billRepository.findAll();
        for (Bill bill : bills) {
            if (bill.getId().equals(id)) {
                return bill;
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

    public Transaction newTransaction(Integer idBill, Integer amount){
        Transaction transaction = new Transaction(idBill, amount);
        transactionRepository.saveAndFlush(transaction);
        return transaction;
    }


    public Transaction findTransactionsById(Integer id) {
        List<Transaction> transactions = transactionRepository.findAll();
        for (Transaction transaction : transactions) {
            if (transaction.getId().equals(id)) {
                return transaction;
            }
        }
        return null;
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
            List<Transaction> transactions = findTransactionsByIdBill(bill.getId());
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
