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
    Integer id;

    @Column(name = "id_client")
    Integer idClient;

    @Column(name = "count_money")
    Integer countMoney;

    public Bill(Integer id, Integer idClient, Integer countMoney){
        this.id = id;
        this.idClient = idClient;
        this.countMoney = countMoney;
    }

    public Bill(Integer idClient, Integer countMoney){
        this.idClient = idClient;
        this.countMoney = countMoney;
    }

    public Bill(){}

}
