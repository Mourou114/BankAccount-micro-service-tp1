package net.mourou.bankaccountservice.web;

import net.mourou.bankaccountservice.entities.BankAccount;
import net.mourou.bankaccountservice.repositories.BankAccountRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
public class AccountRestController {
    private BankAccountRepository bankAccountRepository;


    public AccountRestController(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
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
    public BankAccount save (@RequestBody BankAccount bankAccount){

        return bankAccountRepository.save(bankAccount);
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
        if (bankAccountDto.getCurrency()!=null) bankAccount.setType(bankAccountDto.getType());
        return bankAccountRepository.save(bankAccount);
    }
}