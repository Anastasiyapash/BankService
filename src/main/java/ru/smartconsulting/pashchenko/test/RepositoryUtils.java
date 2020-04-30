package ru.smartconsulting.pashchenko.test;

import lombok.Setter;
import ru.smartconsulting.pashchenko.test.entities.Client;
import ru.smartconsulting.pashchenko.test.entities.Transaction;
import ru.smartconsulting.pashchenko.test.interfaces.BillRepository;
import ru.smartconsulting.pashchenko.test.interfaces.ClientRepository;
import ru.smartconsulting.pashchenko.test.interfaces.TransactionRepository;

import java.util.List;


public class RepositoryUtils {
    ClientRepository clientRepository;
    BillRepository billRepository;
    TransactionRepository transactionRepository;

    public RepositoryUtils() { }

    public Client findByName(String name) {
        List<Client> clientsNameList = clientRepository.findAll();
        for (Client clientName : clientsNameList) {
            if (clientName.getName().equals(name)) {
                return clientName;
            }
        }
        return null;
    }

    public void setRep(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }

    public Transaction findTransByIdBill(Integer idBill){
        List<Transaction> transactionsBillList = transactionRepository.findAll();
        for(Transaction trans : transactionsBillList){
            if(trans.getIdBill() == idBill){
                return trans;
            }
        }
        return null;
    }

    public void setTransRep(TransactionRepository transactionRepository){
        this.transactionRepository = transactionRepository;
    }

}
