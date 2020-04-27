package ru.smartConsulting.pashchenko.test.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.smartConsulting.pashchenko.test.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
}
