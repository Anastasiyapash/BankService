package ru.smartConsulting.pashchenko.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.smartConsulting.pashchenko.test.interfaces.ClientRepository;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

@SpringBootApplication
public class App {
    @Autowired
    static ClientRepository clientRep;

    public static void main(String[] args) throws SQLException, IOException {
        SpringApplication.run(App.class, args);
        Properties property = new Properties();
        FileInputStream fis = new FileInputStream("PATHNAME/BankService/src/main/resources/application.properties");
        property.load(fis);
        String url = property.getProperty("spring.datasource.url");
        String user = property.getProperty("spring.datasource.username");
        String password = property.getProperty("spring.datasource.password");
        System.out.println("Property succesful!");
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println("Connection successful!");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM clients");
        while (resultSet.next()) { // проход пополученным записям
            Integer id = resultSet.getInt("id");
            String name = resultSet.getString("name"); // получение значений полей
            String adress = resultSet.getString("adress");
            Integer age = resultSet.getInt("age");
            System.out.println("Info from db: " + "id: " + id + "|" + "name: " + name + "|"
                    + "adress " + adress + "|" + "age " + age);
        }
        connection.close();
    }
}
