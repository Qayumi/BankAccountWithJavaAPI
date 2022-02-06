package ee.swedb.bankacountrestapi.services.serviceImp;


import ee.swedb.bankacountrestapi.exception.NotFoundException;
import ee.swedb.bankacountrestapi.model.Customer;
import ee.swedb.bankacountrestapi.repository.CustomerRepository;
import ee.swedb.bankacountrestapi.services.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImp implements CustomerService {
    private CustomerRepository customerRepository;

    public CustomerServiceImp(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void createCustomer(Customer customer) {
        this.customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(Long customerId) {
        this.customerRepository.deleteById(customerId);
    }

    @Override
    public Customer updateCustomer(Long customerId, Customer customer) {
        Customer updateCustomer = this.customerRepository.findByCustomerId(customerId).orElseThrow();
        updateCustomer.setName(customer.getName());
        updateCustomer.setLastname(customer.getLastname());
        updateCustomer.setContact(customer.getContact());
        updateCustomer.setEmail(customer.getEmail());
        return this.customerRepository.save(updateCustomer);
    }

    @Override
    public List<Customer> findAllCustomer() {
        return this.customerRepository.findAll();
    }

    @Override
    public Customer findByCustomerId(Long customerId) {
        return this.customerRepository.findByCustomerId(customerId).orElseThrow(() ->
                new NotFoundException("Customer by " + customerId + " customer id was not found"));
    }

    @Override
    public Customer findByCustomerName(String name) {
        return this.customerRepository.findByName(name).orElseThrow(() ->
                new NotFoundException("Customer by " + name + " name was not found"));
    }

    @Override
    public Customer findByCustomerLastname(String lastname) {
        return this.customerRepository.findByLastname(lastname).orElseThrow(() ->
                new NotFoundException("Customer by " + lastname + " lastname was not found"));
    }

    @Override
    public Customer findByCustomerContact(String contact) {
        return this.customerRepository.findByContact(contact).orElseThrow(() ->
                new NotFoundException("Customer by " + contact + " contact was not found"));
    }

    @Override
    public Customer findByCustomerEmail(String email) {
        return this.customerRepository.findByEmail(email).orElseThrow(() ->
                new NotFoundException("Customer by " + email + " email was not found"));
    }
}
