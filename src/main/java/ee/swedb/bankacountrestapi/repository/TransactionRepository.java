package ee.swedb.bankacountrestapi.repository;

import ee.swedb.bankacountrestapi.model.Account;
import ee.swedb.bankacountrestapi.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findAllByAccount(Account account);
    List<Transaction> findAllByTransactionDate(LocalDateTime transactionDate);
    List<Transaction> findAllByBeneficiary(String beneficiary);

}
