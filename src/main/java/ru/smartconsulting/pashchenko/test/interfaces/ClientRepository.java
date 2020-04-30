package ru.smartconsulting.pashchenko.test.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.smartconsulting.pashchenko.test.entities.Client;

import java.util.List;


@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
}
