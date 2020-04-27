package ru.smartConsulting.pashchenko.test;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter @Getter
public class Client {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    Integer id;
    String name;
    String adress;
    Integer age;

    public Client(String name, String adress, Integer age){
        this.name = name;
        this.adress = adress;
        this.age = age;
    }
}
