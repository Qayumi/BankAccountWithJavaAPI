package ee.swedb.bankacountrestapi.services.serviceImp;

import ee.swedb.bankacountrestapi.exception.NotFoundException;
import ee.swedb.bankacountrestapi.model.Account;
import ee.swedb.bankacountrestapi.repository.AccountRepository;
import ee.swedb.bankacountrestapi.services.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImp implements AccountService {

    private AccountRepository accountRepository;

    public AccountServiceImp(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void createAccount(Account account) {
        this.accountRepository.save(account);
    }

    @Override
    public Account updateAccount(Long accountId, Account account) {
        Account updateAccount= this.accountRepository.findByAccountId(accountId).orElseThrow();
        updateAccount.setCustomer(account.getCustomer());
        updateAccount.setAccountType(account.getAccountType());
        updateAccount.setAccountNumber(account.getAccountNumber());
        updateAccount.setBalance(account.getBalance());
        return this.accountRepository.save(account);
    }

    @Override
    public void deleteAccount(Long accountId) {
        this.accountRepository.deleteById(accountId);
    }

    @Override
    public List<Account> findAllAccount() {
        return this.accountRepository.findAll();
    }

    @Override
    public Account findByAccountId(Long accountId) {
        return this.accountRepository.findById(accountId).orElseThrow(() ->
                new NotFoundException("Account by account " + accountId + " id was not found."));
    }

    @Override
    public Account findByCustomerId(Long customerId) {
        return this.accountRepository.findByCustomer(customerId).orElseThrow(() ->
                new NotFoundException("Account by customer " + customerId + " id was not found."));
    }

    @Override
    public Account findByAccountNumber(Long accountNumber) {
        return this.accountRepository.findByAccountNumber(accountNumber).orElseThrow(() ->
                new NotFoundException("Account by account " + accountNumber + " number was not found."));
    }



}
