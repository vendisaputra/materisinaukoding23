package id.sinaukoding23.latihan.repository;

import id.sinaukoding23.latihan.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
