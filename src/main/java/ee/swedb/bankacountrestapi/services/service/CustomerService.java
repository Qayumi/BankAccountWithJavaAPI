package ee.swedb.bankacountrestapi.services.service;

import ee.swedb.bankacountrestapi.model.Customer;

import java.util.List;

public interface CustomerService {
    void createCustomer(Customer customer);
    void deleteCustomer(Long customerId);
    Customer updateCustomer(Long customerId,Customer customer);
    List<Customer> findAllCustomer();
    Customer findByCustomerId(Long customerId);
    Customer findByCustomerName(String name);
    Customer findByCustomerLastname(String lastname);
    Customer findByCustomerContact(String contact);
    Customer findByCustomerEmail(String email);
}
