package com.example.ebankinginitialisation.repositories;

import com.example.ebankinginitialisation.entities.AccountOperation;
import com.example.ebankinginitialisation.entities.BankAccount;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountOperationRepository extends JpaRepository <AccountOperation, Long> {

    List<AccountOperation> findByBankAccountId(String accountId);
    Page<AccountOperation> findByBankAccountId(String accountId, Pageable pageable);
    
}
