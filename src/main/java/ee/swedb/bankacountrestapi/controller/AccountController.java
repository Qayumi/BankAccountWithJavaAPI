package ee.swedb.bankacountrestapi.controller;

import ee.swedb.bankacountrestapi.model.Account;
import ee.swedb.bankacountrestapi.model.AccountType;
import ee.swedb.bankacountrestapi.model.Customer;
import ee.swedb.bankacountrestapi.services.serviceImp.AccountServiceImp;
import ee.swedb.bankacountrestapi.services.serviceImp.AccountTypeServiceImp;
import ee.swedb.bankacountrestapi.services.serviceImp.CustomerServiceImp;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {
    private AccountServiceImp accountServiceImp;
    private AccountTypeServiceImp accountTypeServiceImp;
    private CustomerServiceImp customerServiceImp;

    public AccountController(AccountServiceImp accountServiceImp,
                             AccountTypeServiceImp accountTypeServiceImp,CustomerServiceImp customerServiceImp) {
        this.accountServiceImp = accountServiceImp;
        this.accountTypeServiceImp=accountTypeServiceImp;
        this.customerServiceImp=customerServiceImp;
        AccountType accountType=new AccountType(1L,"USD");
        this.accountTypeServiceImp.createAccountType(accountType);
        Customer customer=new Customer(1L,"admin","admin","admin@admin.com","123456");
        this.customerServiceImp.createCustomer(customer);
        Account account=new Account(1L,customer,accountType,123456L,100L);
        this.accountServiceImp.createAccount(account);
    }

    @GetMapping("/")
    public List<Account> getAllAccount() {
        return accountServiceImp.findAllAccount();
    }

    @PostMapping("/")
    public void createAccount(@RequestBody Account account) {
        this.accountServiceImp.createAccount(account);
    }

    @PutMapping("/{id}")
    public void updateAccount(@PathVariable("id") Long accountId,@RequestBody Account account){
        this.accountServiceImp.updateAccount(accountId,account);
    }

    @DeleteMapping("/{id}")
    public void deleteAccount(@PathVariable("id") Long accountId){
        this.accountServiceImp.deleteAccount(accountId);
    }
}
