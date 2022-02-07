package ee.swedb.bankacountrestapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long customerId;
    @Column(name = "name", nullable = false, length = 30)
    private String name;
    @Column(name = "lastname", nullable = false, length = 30)
    private String lastname;
    @Column(name = "email", nullable = false, length = 30)
    private String email;
    @Column(name = "contact", nullable = false, length = 30)
    private String contact;
}
