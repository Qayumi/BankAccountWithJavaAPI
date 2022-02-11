package ee.swedb.bankacountrestapi.services.serviceImp;
import ee.swedb.bankacountrestapi.model.Account;
import ee.swedb.bankacountrestapi.model.Transaction;
import ee.swedb.bankacountrestapi.repository.AccountRepository;
import ee.swedb.bankacountrestapi.repository.TransactionRepository;
import ee.swedb.bankacountrestapi.services.service.TransactionService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransactionServiceImp implements TransactionService {
    private TransactionRepository transactionRepository;
    private AccountRepository accountRepository;

    public TransactionServiceImp(TransactionRepository transactionRepository, AccountRepository accountRepository) {
        this.transactionRepository = transactionRepository;
        this.accountRepository = accountRepository;
    }

    @Override
    public void createTransaction(Transaction transaction) {
        this.transactionRepository.save(transaction);
    }

    @Override
    public void deleteTransaction(Long transactionId) {
        this.transactionRepository.deleteById(transactionId);
    }

    @Override
    public Transaction updateTransaction(Long transactionId, Transaction transaction) {
        Transaction updateTransaction = this.transactionRepository.findById(transactionId).orElseThrow();

        updateTransaction.setTransactionDate(transaction.getTransactionDate());
        updateTransaction.setTransactionDetails(transaction.getTransactionDetails());
        updateTransaction.setBeneficiary(transaction.getBeneficiary());
        updateTransaction.setAccount(transaction.getAccount());
        updateTransaction.setAmount(transaction.getAmount());

        return this.transactionRepository.save(transaction);
    }

    @Override
    public Transaction findByTransactionId(Long transactionId) {
        return this.transactionRepository.findById(transactionId).orElseThrow();
    }

    @Override
    public List<Transaction> findAllTransactionByAccountId(Long accountId) {
        Account account = this.accountRepository.findByAccountId(accountId).orElseThrow();
        return this.transactionRepository.findAllByAccount(account);
    }

    @Override
    public List<Transaction> findAllTransactionByDate(LocalDateTime transactionDate) {
        return this.transactionRepository.findAllByTransactionDate(transactionDate);
    }

    @Override
    public List<Transaction> findAllTransactionByBeneficiary(String beneficiary) {
        return this.transactionRepository.findAllByBeneficiary(beneficiary);
    }

    @Override
    public List<Transaction> findAllTransaction() {
        return this.transactionRepository.findAll();
    }
}
