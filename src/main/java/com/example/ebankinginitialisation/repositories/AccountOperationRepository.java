package com.example.ebankinginitialisation.repositories;

import com.example.ebankinginitialisation.entities.AccountOperation;
import com.example.ebankinginitialisation.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountOperationRepository extends JpaRepository <AccountOperation, Long> {
    
}
