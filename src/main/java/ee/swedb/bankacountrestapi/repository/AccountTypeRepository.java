package ee.swedb.bankacountrestapi.repository;

import ee.swedb.bankacountrestapi.model.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountTypeRepository extends JpaRepository<AccountType,Long> {
}
