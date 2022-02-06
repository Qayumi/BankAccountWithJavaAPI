package ee.swedb.bankacountrestapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountType {
    @Id
    @Column(name = "account_type_id", nullable = false)
    private Long accountTypeId;
    @Column(name = "account_type", nullable = false)
    private String accountType;
}
