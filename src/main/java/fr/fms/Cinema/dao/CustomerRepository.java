package fr.fms.Cinema.dao;

import fr.fms.Cinema.Entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
