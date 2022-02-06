package ee.swedb.bankacountrestapi.services.service;

import ee.swedb.bankacountrestapi.model.AccountType;

import java.util.List;

public interface AccountTypeService {
    void createAccountType(AccountType accountType);
    void deleteAccountTypeId(Long accountTypeId);
    AccountType updateAccountType(Long accountTypeId,AccountType accountType);
    AccountType findByAccountTypeId(Long accountTypeId);
    List<AccountType> findAllAccountType();
}
