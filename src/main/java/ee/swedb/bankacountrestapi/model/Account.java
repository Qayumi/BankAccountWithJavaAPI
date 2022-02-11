package ee.swedb.bankacountrestapi.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.math.BigDecimal;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id", nullable = false)
    private Long accountId;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column(name = "account_type")
    private String accountType;

    @Column(name = "account_number", nullable = false)
    private Long accountNumber;

    @Column(name = "balance",nullable = false, precision=12, scale=2)
    private BigDecimal balance;
}
