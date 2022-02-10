package ee.swedb.bankacountrestapi.controller;

import ee.swedb.bankacountrestapi.model.Account;
import ee.swedb.bankacountrestapi.model.Customer;
import ee.swedb.bankacountrestapi.model.Transaction;
import ee.swedb.bankacountrestapi.services.serviceImp.AccountServiceImp;
import ee.swedb.bankacountrestapi.services.serviceImp.CustomerServiceImp;
import ee.swedb.bankacountrestapi.services.serviceImp.TransactionServiceImp;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/account")
public class AccountController {
    private AccountServiceImp accountServiceImp;
    private CustomerServiceImp customerServiceImp;
    private TransactionServiceImp transactionServiceImp;

    public AccountController(AccountServiceImp accountServiceImp
                            ,CustomerServiceImp customerServiceImp, TransactionServiceImp transactionServiceImp) {
        this.accountServiceImp = accountServiceImp;
        this.customerServiceImp=customerServiceImp;
        this.transactionServiceImp=transactionServiceImp;
        Customer customer=new Customer(1L,"admin","admin","admin@admin.com","123456");
        this.customerServiceImp.createCustomer(customer);
        Account account=new Account(1L,customer,"EUR",123456L,100L);
        this.accountServiceImp.createAccount(account);
        LocalDateTime localDateTime=LocalDateTime.now();
        Transaction transaction=new Transaction(1L, account, 20L,localDateTime, "Remi","To buy food");
        this.transactionServiceImp.createTransaction(transaction);
    }

    @GetMapping()
    public List<Account> getAllAccount() {
        return accountServiceImp.findAllAccount();
    }

    @PostMapping()
    public void createAccount(@RequestBody Account account) {
        this.accountServiceImp.createAccount(account);
    }

    @PutMapping("{id}")
    public void updateAccount(@PathVariable("id") Long accountId,@RequestBody Account account){
        this.accountServiceImp.updateAccount(accountId,account);
    }

    @DeleteMapping("{id}")
    public void deleteAccount(@PathVariable("id") Long accountId){
        this.accountServiceImp.deleteAccount(accountId);
    }

    @RequestMapping("/{id}")
    public Account getAccountById(@PathVariable("id") Long accountId){
        return this.accountServiceImp.findByAccountId(accountId);
    }

}
