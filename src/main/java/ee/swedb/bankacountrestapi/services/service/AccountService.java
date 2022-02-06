package ee.swedb.bankacountrestapi.services.service;

import ee.swedb.bankacountrestapi.model.Account;

import java.util.List;

public interface AccountService {
    void createAccount(Account account);
    void deleteAccount(Long accountId);
    Account updateAccount(Long accountId,Account account);
    List<Account> findAllAccount();
    Account findByAccountId(Long accountId);
    Account findByCustomerId(Long customerId);
    Account findByAccountNumber(Long accountNumber);
}
