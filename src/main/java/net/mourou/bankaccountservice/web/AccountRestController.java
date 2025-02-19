package net.mourou.bankaccountservice.web;

import net.mourou.bankaccountservice.dto.BankAccountRequestDTO;
import net.mourou.bankaccountservice.dto.BankAccountResponseDTO;
import net.mourou.bankaccountservice.entities.BankAccount;
import net.mourou.bankaccountservice.mappers.AccountMapper;
import net.mourou.bankaccountservice.repositories.BankAccountRepository;
import net.mourou.bankaccountservice.service.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/api")
public class AccountRestController {
    private BankAccountRepository bankAccountRepository;
    private AccountService accountService;
    private AccountMapper accountMapper;


    public AccountRestController(BankAccountRepository bankAccountRepository, AccountService accountService, AccountMapper accountMapper) {
        this.bankAccountRepository = bankAccountRepository;
        this.accountService = accountService;
        this.accountMapper = accountMapper;
    }


    @GetMapping("/bankAccounts")
    public List<BankAccount> getAllbankAccounts(){

        return bankAccountRepository.findAll();
    }



    @GetMapping("/bankAccounts/{id}")
    public BankAccount getAccountByid(@PathVariable(name ="id") String id){
        return bankAccountRepository.findById(id).orElseThrow(()->new RuntimeException(String.format("Account %s not found",id)));
    }


    @PostMapping("/bankAccounts")
    public BankAccountResponseDTO save (@RequestBody BankAccountRequestDTO requestDTO){
        return accountService.addAccount(requestDTO);
    }

    @DeleteMapping("/bankAccounts/{id}")
    public void delete(@PathVariable(name ="id") String id){
        bankAccountRepository.deleteById(id);
    }

    @PutMapping("/bankAccounts/{id}")
    public BankAccount update(@PathVariable String id, @RequestBody BankAccount bankAccountDto){
        BankAccount bankAccount = bankAccountRepository.findById(id).orElseThrow();
        if (bankAccountDto.getBalance()!=null) bankAccount.setBalance(bankAccountDto.getBalance());
        if (bankAccountDto.getCreatedAt()!=null) bankAccount.setCreatedAt(bankAccountDto.getCreatedAt());
        if (bankAccountDto.getType()!=null) bankAccount.setType(bankAccountDto.getType());
        if (bankAccountDto.getCurrency()!=null) bankAccount.setCurrency(bankAccountDto.getCurrency());
        return bankAccountRepository.save(bankAccount);
    }
}