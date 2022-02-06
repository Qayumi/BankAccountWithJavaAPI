package ee.swedb.bankacountrestapi.services.serviceImp;


import ee.swedb.bankacountrestapi.exception.NotFoundException;
import ee.swedb.bankacountrestapi.model.AccountType;
import ee.swedb.bankacountrestapi.repository.AccountTypeRepository;
import ee.swedb.bankacountrestapi.services.service.AccountTypeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountTypeServiceImp implements AccountTypeService {
    private AccountTypeRepository accountTypeRepository;

    public AccountTypeServiceImp(AccountTypeRepository accountTypeRepository) {
        this.accountTypeRepository = accountTypeRepository;
    }

    @Override
    public void createAccountType(AccountType accountType) {
        this.accountTypeRepository.save(accountType);
    }

    @Override
    public void deleteAccountTypeId(Long accountTypeId) {
        this.accountTypeRepository.deleteById(accountTypeId);
    }

    @Override
    public AccountType updateAccountType(Long accountTypeId,AccountType accountType) {
        AccountType updateAccountType= this.accountTypeRepository.findById(accountTypeId).orElseThrow();
        updateAccountType.setAccountType(accountType.getAccountType());
        return this.accountTypeRepository.save(accountType);
    }

    @Override
    public AccountType findByAccountTypeId(Long accountTypeId) {
        return this.accountTypeRepository.findById(accountTypeId).orElseThrow(() ->
                new NotFoundException("Account type by account " + accountTypeId + " type id was not found."));
    }

    @Override
    public List<AccountType> findAllAccountType() {
        return this.accountTypeRepository.findAll();
    }
}
