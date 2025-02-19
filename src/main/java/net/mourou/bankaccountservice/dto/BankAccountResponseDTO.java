package net.mourou.bankaccountservice.dto;

import lombok.*;
import net.mourou.bankaccountservice.enums.AccountType;

import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BankAccountResponseDTO {
    private String id;
    private Date createdAt;
    private Double balance;
    private String currency;
    private AccountType type;

}
