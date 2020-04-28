package ru.smartconsulting.pashchenko.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ru.smartconsulting.pashchenko.test.interfaces.ClientRepository;

import java.util.List;

@SpringBootApplication
public class App implements CommandLineRunner {
    @Autowired
    private ClientRepository repository;

    public static void main(String[] args) {
       SpringApplication.run(App.class, args);
    }

    public void run(String... args) {
        List<Client> clientList = repository.findAll();
        for(Client printer : clientList){
            System.out.println("IN DB| id " + printer.id + "|name " + printer.name + "| adress " + printer.adress
                    + "| age " + printer.age);
        }
    }
}
