package net.mourou.bankaccountservice.dto;
import lombok.*;
import net.mourou.bankaccountservice.enums.AccountType;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BankAccountRequestDTO {
    private Double balance;
    private String currency;
    private AccountType type;
}
