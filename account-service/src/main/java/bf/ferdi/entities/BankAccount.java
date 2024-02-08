package bf.ferdi.entities;

import bf.ferdi.enums.AccountType;
import bf.ferdi.model.Customer;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
public class BankAccount {

    @Id
    private  String accountId;
    private  double balance;
    private LocalDate createdAt;
    private String currency;

    @Enumerated(EnumType.STRING)
    private AccountType type;

    @Transient
    private Customer customer;
    private Long customerId;
}
