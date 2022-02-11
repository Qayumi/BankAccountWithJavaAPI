package ee.swedb.bankacountrestapi.repository;

import ee.swedb.bankacountrestapi.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;


@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {
    Optional<Account> findByAccountId(Long accountId);
    Optional<Account> findByCustomer(Long accountId);
    Optional<Account> findByAccountNumber(Long accountId);
}
