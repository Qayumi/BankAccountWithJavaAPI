package ee.swedb.bankacountrestapi.repository;

import ee.swedb.bankacountrestapi.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository <Customer,Long> {
    Optional<Customer> findByCustomerId(Long customerId);
    Optional<Customer> findByContact(String contact);
    Optional<Customer> findByName(String name);
    Optional<Customer> findByLastname(String lastname);
    Optional<Customer> findByEmail(String lastname);

}
