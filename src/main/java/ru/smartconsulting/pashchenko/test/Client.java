package ru.smartconsulting.pashchenko.test;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "clients")
public class Client {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    @Column(name = "name")
    String name;
    @Column(name = "adress")
    String adress;
    @Column(name = "age")
    Integer age;

    public Client(String name, String adress, Integer age){
        this.name = name;
        this.adress = adress;
        this.age = age;
    }
    public Client(){ }

}
