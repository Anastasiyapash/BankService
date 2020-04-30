package ru.smartconsulting.pashchenko.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ru.smartconsulting.pashchenko.test.entities.Client;
import ru.smartconsulting.pashchenko.test.entities.Transaction;
import ru.smartconsulting.pashchenko.test.interfaces.BillRepository;
import ru.smartconsulting.pashchenko.test.interfaces.ClientRepository;
import ru.smartconsulting.pashchenko.test.interfaces.TransactionRepository;

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
        RepositoryUtils repositoryUtils = new RepositoryUtils();
        repositoryUtils.setRep(clientRepository);
        Client clientName = repositoryUtils.findByName("Ivan");
        System.out.println(clientName.getId() + " " + clientName.getName());
        repositoryUtils.setTransRep(transactionRepository);
        Transaction transaction = repositoryUtils.findTransByIdBill(1);
        System.out.println(transaction.getIdTrans() + " " + transaction.getIdBill());

    }

}
