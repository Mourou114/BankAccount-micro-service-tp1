package net.mourou.bankaccountservice;

import net.mourou.bankaccountservice.entities.BankAccount;
import net.mourou.bankaccountservice.entities.Customer;
import net.mourou.bankaccountservice.enums.AccountType;
import net.mourou.bankaccountservice.repositories.BankAccountRepository;
import net.mourou.bankaccountservice.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class BankAccountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankAccountServiceApplication.class, args);
	}


	@Bean
	CommandLineRunner commandLineRunner(BankAccountRepository bankAccountRepository, CustomerRepository customerRepository){
		return arg -> {

			Stream.of("youness","imane","alaa","radi").forEach(c->{
				Customer customer = Customer.builder()
						.name(c)
						.build();
				customerRepository.save(customer);
			});
			customerRepository.findAll().forEach(customer -> {
				for (int i = 0; i <10 ; i++) {
					BankAccount bankAccount = BankAccount.builder()
							.id(UUID.randomUUID().toString())
							.type(Math.random()>0.5? AccountType.CURRENT_ACCOUNT:AccountType.SAVING_ACCOUNT)
							.balance(1000+Math.random()*9000)
							.createdAt(new Date())
							.currency("MAD")
							.customer(customer)
							.build();
					bankAccountRepository.save(bankAccount);
				}

			});

		};
	}

}
