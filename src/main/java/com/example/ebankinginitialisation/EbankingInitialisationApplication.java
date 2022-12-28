package com.example.ebankinginitialisation;

import com.example.ebankinginitialisation.entities.*;
import com.example.ebankinginitialisation.enums.AccountStatus;
import com.example.ebankinginitialisation.enums.OperationType;
import com.example.ebankinginitialisation.repositories.AccountOperationRepository;
import com.example.ebankinginitialisation.repositories.BankAccountRepository;
import com.example.ebankinginitialisation.repositories.CustomerRepository;
import com.example.ebankinginitialisation.services.BankService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class EbankingInitialisationApplication {

    public static void main(String[] args) {
        SpringApplication.run(EbankingInitialisationApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(BankService bankService){
        return args -> {
            bankService.consulter();
        };
    }


   // @Bean
    CommandLineRunner start (CustomerRepository customerRepository,
                             BankAccountRepository bankAccountRepository,
                             AccountOperationRepository accountOperationRepository){
        return args -> {
            Stream.of("hassan","yassine","Aicha").forEach(name->{
                Customer customer = new Customer();
                customer.setName(name);
                customer.setEmail(name+"@gmail.com");
                customerRepository.save(customer);
            });
            customerRepository.findAll().forEach(cust ->{
                CurrentAccount currentAccount = new CurrentAccount();
                currentAccount.setId(UUID.randomUUID().toString());
                currentAccount.setBalance(Math.random()*90000);
                currentAccount.setStatus(AccountStatus.CREATED);
                currentAccount.setCreatedAt(new Date());
                currentAccount.setCustomer(cust);
                currentAccount.setOverDraft(9000);
                bankAccountRepository.save(currentAccount);

                SavingAccount savingAccount = new SavingAccount();
                savingAccount.setId(UUID.randomUUID().toString());
                savingAccount.setBalance(Math.random()*90000);
                savingAccount.setStatus(AccountStatus.CREATED);
                savingAccount.setCreatedAt(new Date());
                savingAccount.setCustomer(cust);
                savingAccount.setInterestRate(5.5);
                bankAccountRepository.save(savingAccount);


            });
            bankAccountRepository.findAll().forEach(acc->{
                for (int i = 0; i<10; i++){
                    AccountOperation accountOperation = new AccountOperation();
                    accountOperation.setOperationDate(new Date());
                    accountOperation.setAmount(Math.random()*12000);
                    accountOperation.setType(Math.random()>0.5? OperationType.DEBIT: OperationType.CREDIT);
                    accountOperation.setBankAccount(acc);
                    accountOperationRepository.save(accountOperation);
                }
            });

        };

    }
}

