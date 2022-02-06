package ee.swedb.bankacountrestapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
    @Id
    @Column(name = "transaction_id", nullable = false)
    private Long transactionId;

    @JoinColumn(name = "account_id",nullable = false)
    private Long accountId;

    @Column(name = "amount", nullable = false)
    private Long amount;

    @Column(name = "transaction_date",nullable = false)
    private LocalDateTime transactionDate;

    @Column(name = "beneficiary", nullable = false)
    private String beneficiary;

    @Column(name = "transaction_details", nullable = false)
    private String transactionDetails;
}
