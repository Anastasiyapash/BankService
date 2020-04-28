package ru.smartConsulting.pashchenko.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.smartConsulting.pashchenko.test.interfaces.ClientRepository;
import java.sql.*;

@SpringBootApplication
public class App {
    @Autowired
    static ClientRepository clientRep;

    public static void main(String[] args) throws SQLException {
        SpringApplication.run(App.class, args);
        String url = "jdbc:postgresql://127.0.0.1:5432/NAMEDB";
        String user = "USERNAME";
        String password = "USERPASSWORD";
        System.out.println("OK0");
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println("Connection successful!");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM clients");
        while (resultSet.next()) { // проход пополученным записям
            Integer id = resultSet.getInt("id");
            String name = resultSet.getString("name"); // получение значений полей
            String adress = resultSet.getString("adress");
            Integer age = resultSet.getInt("age");
            System.out.println("Info from db: " + "id: " + id + " " + "name: " + name + " "
                    + "adress " + adress + " " + "age " + age);
        }
        connection.close();
    }
}
