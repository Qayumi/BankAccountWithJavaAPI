package ee.swedb.bankacountrestapi.controller;


import ee.swedb.bankacountrestapi.model.AccountType;
import ee.swedb.bankacountrestapi.services.serviceImp.AccountTypeServiceImp;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accountType")
public class AccountTypeController {
    private AccountTypeServiceImp accountTypeServiceImp;

    public AccountTypeController(AccountTypeServiceImp accountTypeServiceImp) {
        this.accountTypeServiceImp = accountTypeServiceImp;

    }

    @GetMapping("/")
    public List<AccountType> getAllAccountType() {
        return this.accountTypeServiceImp.findAllAccountType();
    }

    @PostMapping("/")
    public void createAccountType(@RequestBody AccountType accountType) {
        this.accountTypeServiceImp.createAccountType(accountType);
    }

    @PutMapping("/{id}")
    public AccountType updateAccountType(@PathVariable("id") Long accountTypeId, @RequestBody AccountType accountType) {
        return this.accountTypeServiceImp.updateAccountType(accountTypeId, accountType);
    }

    @DeleteMapping("/{id}")
    public void deleteAccountType(@PathVariable("id") Long accountTypeId) {
        this.accountTypeServiceImp.deleteAccountTypeId(accountTypeId);
    }
}
