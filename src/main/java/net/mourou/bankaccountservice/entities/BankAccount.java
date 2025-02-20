package net.mourou.bankaccountservice.entities;

import jakarta.persistence.*;
import lombok.*;
import net.mourou.bankaccountservice.enums.AccountType;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BankAccount {
    @Id
    private String id;
    private Date createdAt;
    private Double balance;
    private String currency;
    @Enumerated(EnumType.STRING)
    private AccountType type;
    @ManyToOne
    private Customer customer;

}
