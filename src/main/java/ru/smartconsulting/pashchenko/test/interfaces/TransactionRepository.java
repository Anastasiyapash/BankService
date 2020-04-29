package ru.smartconsulting.pashchenko.test.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.smartconsulting.pashchenko.test.entities.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
}
