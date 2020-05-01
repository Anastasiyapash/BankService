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
        RepositoryUtils repositoryUtils = new RepositoryUtils();

        repositoryUtils.setRep(clientRepository);
        Client clientName = repositoryUtils.findByName("Ivan");
        System.out.println(clientName.getId() + " " + clientName.getName());
        List<Client> allClients = repositoryUtils.findAllByClient();
        for(Client alls : allClients){
            System.out.println(" ALL CLIENTS: " + alls.getId() + " " + alls.getName());
        }

        repositoryUtils.setBillRep(billRepository);
        List<Bill> allBills = repositoryUtils.findAllBill();
        for(Bill alls: allBills){
            System.out.println("ALL BILLS: " + alls.getIdBill() + " " + alls.getIdClient() + " " + alls.getCountMoney());
        }
        List<Bill> billList = repositoryUtils.findByIdClient(1);
        for(Bill bills : billList){
            System.out.println("ALL BILLS WHERE ID 1 " + bills.getIdBill() + " " + bills.getIdClient() + " "
                    + bills.getCountMoney());
        }

        repositoryUtils.setTransRep(transactionRepository);
        List<Transaction> allTrans =repositoryUtils.findByAllTransaction();
        for(Transaction alls : allTrans){
            System.out.println("ALL TRANS: " + alls.getIdTrans() + " " + alls.getIdBill() + " " + alls.getAmount());
        }

        List<Transaction> transaction = repositoryUtils.findTransByIdBill(1);
        for(Transaction trans :  transaction){
            System.out.println(trans.getIdTrans() + " " + trans.getIdBill() + " " + trans.getAmount());
        }

        List<Transaction> allTransUser = repositoryUtils.fidTransByIdClient(1);
        for(Transaction trans : allTransUser){
            System.out.println("ALL TRANSACTIONS USER 1: " + trans.getIdTrans());
        }
    }

}
