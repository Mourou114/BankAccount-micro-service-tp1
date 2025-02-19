package net.mourou.bankaccountservice.service;

import net.mourou.bankaccountservice.dto.BankAccountRequestDTO;
import net.mourou.bankaccountservice.dto.BankAccountResponseDTO;

public interface AccountService {

    BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO);
}
