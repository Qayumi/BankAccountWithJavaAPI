package ee.swedb.bankacountrestapi.repository;

import ee.swedb.bankacountrestapi.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findAllByAccountId(Long accountId);
    List<Transaction> findAllByTransactionDate(LocalDateTime transactionDate);
    List<Transaction> findAllByBeneficiary(String beneficiary);

}
