package ru.smartconsulting.pashchenko.test.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
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

    public Client(Integer id, String name, String adress, Integer age){
        this.id = id;
        this.name = name;
        this.adress = adress;
        this.age = age;
    }

    public Client(String name, String adress, Integer age){
        this.name = name;
        this.adress = adress;
        this.age = age;
    }

    public Client(){ }

}
