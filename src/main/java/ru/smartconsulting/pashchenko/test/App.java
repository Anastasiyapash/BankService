package ru.smartconsulting.pashchenko.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ru.smartconsulting.pashchenko.test.entities.Bill;
import ru.smartconsulting.pashchenko.test.entities.Client;
import ru.smartconsulting.pashchenko.test.entities.Transaction;
import ru.smartconsulting.pashchenko.test.interfaces.BillRepository;
import ru.smartconsulting.pashchenko.test.interfaces.ClientRepository;
import ru.smartconsulting.pashchenko.test.interfaces.TransactionRepository;

import java.util.List;

@SpringBootApplication
public class App implements CommandLineRunner {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private BillRepository billRepository;
    @Autowired
    private TransactionRepository transactionRepository;

    public static void main(String[] args) {
       SpringApplication.run(App.class, args);
    }

    public void run(String... args) {
        clientRepository.saveAndFlush(new Client("Mark", "tver", 21));
        billRepository.saveAndFlush(new Bill(1, 5000));
        transactionRepository.saveAndFlush(new Transaction(1, -200));
        List<Client> clientList = clientRepository.findAll();

        for(Client clients : clientList){
            System.out.println("IN CLIENTS TABLE| id " + clients.getId() + "|name " + clients.getName() +
                    "| adress " + clients.getAdress() + "| age " + clients.getAge());
        }

        List<Bill> billList = billRepository.findAll();
        for(Bill bills : billList){
            System.out.println("IN BILLS TABLE| id_bill " + bills.getId_bill() + "|id_client " + bills.getId_client()
                    + "|count_money " + bills.getCount_money());
        }

        List<Transaction> transactionList = transactionRepository.findAll();
        for(Transaction transactions : transactionList){
            System.out.println("IN TRANSACTION TABLE |id_trans " + transactions.getId_trans()
                + "|id_bill " + transactions.getId_bill() + "|amount " + transactions.getAmount());
        }
    }
}
