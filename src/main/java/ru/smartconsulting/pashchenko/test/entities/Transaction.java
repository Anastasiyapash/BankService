package ru.smartconsulting.pashchenko.test.entities;



import javax.persistence.*;

@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @Column(name = "id_trans")
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    @Column(name = "id_bill")
    Integer idBill;

    @Column(name = "amount")
    Integer amount;

    public Transaction(Integer idTrans, Integer idBill, Integer amount){
        this.id = idTrans;
        this.idBill = idBill;
        this.amount = amount;
    }

    public Transaction(Integer idBill, Integer amount){
        this.idBill = idBill;
        this.amount = amount;
    }

    public Transaction(){ }

    public Integer getId(){
        return id;
    }

    public Integer getIdBill(){
        return idBill;
    }

}
