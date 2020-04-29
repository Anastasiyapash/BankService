package ru.smartconsulting.pashchenko.test.entities;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "bills")
public class Bill {
    @Id
    @Column(name = "id_bill")
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id_bill;

    @Column(name = "id_client")
    Integer id_client;

    @Column(name = "count_money")
    Integer count_money;

    public Bill(Integer id_bill, Integer id_client, Integer count_money){
        this.id_bill = id_bill;
        this.id_client = id_client;
        this.count_money = count_money;
    }

    public Bill(Integer id_client, Integer count_money){
        this.id_client = id_client;
        this.count_money = count_money;
    }

    public Bill(){}

}
