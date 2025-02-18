package net.mourou.bankaccountservice.repositories;

import net.mourou.bankaccountservice.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BankAccountRepository extends JpaRepository<BankAccount, String> {

}
