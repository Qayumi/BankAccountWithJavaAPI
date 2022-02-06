package ee.swedb.bankacountrestapi.controller;

import ee.swedb.bankacountrestapi.model.Customer;
import ee.swedb.bankacountrestapi.services.serviceImp.CustomerServiceImp;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    private CustomerServiceImp customerServiceImp;

    public CustomerController(CustomerServiceImp customerServiceImp) {
        this.customerServiceImp = customerServiceImp;
    }

    @GetMapping("/")
    public List<Customer> getAllCustomers() {
        return customerServiceImp.findAllCustomer();
    }

    @RequestMapping("/{id}")
    public Customer getCustomerById(@PathVariable("id") Long customerId) {
        return this.customerServiceImp.findByCustomerId(customerId);
    }

    @PostMapping("/")
    public void createCustomer(@RequestBody Customer customer) {
        this.customerServiceImp.createCustomer(customer);
    }

    @PutMapping("/{id}")
    public Customer updateCustomer(@PathVariable("id") Long customerId, @RequestBody Customer customer) {
        return this.customerServiceImp.updateCustomer(customerId, customer);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable("id") Long customerId) {
        this.customerServiceImp.deleteCustomer(customerId);
    }

}
