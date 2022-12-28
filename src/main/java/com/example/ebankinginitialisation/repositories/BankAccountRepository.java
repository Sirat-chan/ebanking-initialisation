package com.example.ebankinginitialisation.repositories;

import com.example.ebankinginitialisation.entities.BankAccount;
import com.example.ebankinginitialisation.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository <BankAccount, String> {
    
}
