package ru.smartconsulting.pashchenko.test.entities;


import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @Column(name = "id_trans")
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id_trans;

    @Column(name = "id_bill")
    Integer id_bill;

    @Column(name = "amount")
    Integer amount;

    public Transaction(Integer id_trans, Integer id_bill, Integer amount){
        this.id_trans = id_trans;
        this.id_bill = id_bill;
        this.amount = amount;
    }

    public Transaction(Integer id_bill, Integer amount){
        this.id_bill = id_bill;
        this.amount = amount;
    }

    public Transaction(){ }
}
