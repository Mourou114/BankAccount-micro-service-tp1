package net.mourou.bankaccountservice.service;

import net.mourou.bankaccountservice.dto.BankAccountRequestDTO;
import net.mourou.bankaccountservice.dto.BankAccountResponseDTO;
import net.mourou.bankaccountservice.entities.BankAccount;
import net.mourou.bankaccountservice.mappers.AccountMapper;
import net.mourou.bankaccountservice.repositories.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;


@Service
@Transactional
public class AccountServiceImpl implements AccountService{
    @Autowired
    private BankAccountRepository bankAccountRepository;
    @Autowired
    private AccountMapper accountMapper;
    @Override
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO) {
        BankAccount bankAccount = BankAccount.builder()
                .id(UUID.randomUUID().toString())
                .createdAt(new Date())
                .type(bankAccountDTO.getType())
                .balance(bankAccountDTO.getBalance())
                .currency(bankAccountDTO.getCurrency())
                .build();
        BankAccount saveBankAccount = bankAccountRepository.save(bankAccount);
        /*BankAccountResponseDTO bankAccountResponseDTO = BankAccountResponseDTO.builder()
                .id(saveBankAccount.getId())
                .createdAt(saveBankAccount.getCreatedAt())
                .type(saveBankAccount.getType())
                .balance(saveBankAccount.getBalance())
                .currency(saveBankAccount.getCurrency())
                .build();*/


        BankAccountResponseDTO bankAccountResponseDTO =accountMapper.fromBankAccount(saveBankAccount);
        return bankAccountResponseDTO;
    }
    @Override
    public BankAccountResponseDTO updateAccount(String id, BankAccountRequestDTO bankAccountDTO) {
        BankAccount bankAccount = BankAccount.builder()
                .id(id)
                .createdAt(new Date())
                .type(bankAccountDTO.getType())
                .balance(bankAccountDTO.getBalance())
                .currency(bankAccountDTO.getCurrency())
                .build();
        BankAccount saveBankAccount = bankAccountRepository.save(bankAccount);

        BankAccountResponseDTO bankAccountResponseDTO =accountMapper.fromBankAccount(saveBankAccount);
        return bankAccountResponseDTO;
    }
}
