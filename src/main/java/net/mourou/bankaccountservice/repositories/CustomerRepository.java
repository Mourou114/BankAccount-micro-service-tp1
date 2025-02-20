package net.mourou.bankaccountservice.repositories;

import net.mourou.bankaccountservice.entities.BankAccount;
import net.mourou.bankaccountservice.entities.Customer;
import net.mourou.bankaccountservice.enums.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;


public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
