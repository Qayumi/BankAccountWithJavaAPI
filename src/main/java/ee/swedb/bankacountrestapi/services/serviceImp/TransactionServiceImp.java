package ee.swedb.bankacountrestapi.services.serviceImp;


import ee.swedb.bankacountrestapi.model.Transaction;
import ee.swedb.bankacountrestapi.repository.TransactionRepository;
import ee.swedb.bankacountrestapi.services.service.TransactionService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransactionServiceImp implements TransactionService {
    private TransactionRepository transactionRepository;

    public TransactionServiceImp(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
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
        updateTransaction.setAccountId(transaction.getAccountId());
        updateTransaction.setAmount(transaction.getAmount());

        return this.transactionRepository.save(transaction);
    }

    @Override
    public Transaction findByTransactionId(Long transactionId) {
        return this.transactionRepository.findById(transactionId).orElseThrow();
    }

    @Override
    public List<Transaction> findAllTransactionByAccountId(Long accountId) {
        return this.transactionRepository.findAllByAccountId(accountId);
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
