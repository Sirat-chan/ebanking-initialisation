package com.example.ebankinginitialisation.services;

import com.example.ebankinginitialisation.entities.BankAccount;
import com.example.ebankinginitialisation.entities.CurrentAccount;
import com.example.ebankinginitialisation.entities.SavingAccount;
import com.example.ebankinginitialisation.repositories.BankAccountRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class BankService {
    @Autowired
    private BankAccountRepository bankAccountRepository;
    public void consulter() {
        BankAccount bankAccount
                = bankAccountRepository.findById("440e9374-7f12-41dd-94d5-0da9930b9b63").orElse(null);
        if (bankAccount != null) {
            System.out.println("********************");
            System.out.println(bankAccount.getId());
            System.out.println(bankAccount.getBalance());
            System.out.println(bankAccount.getStatus());
            System.out.println(bankAccount.getCreatedAt());
            System.out.println(bankAccount.getCustomer().getName());
            System.out.println(bankAccount.getClass().getSimpleName());
            if (bankAccount instanceof CurrentAccount) {
                System.out.println("Over Draft =>" + ((CurrentAccount) bankAccount).getOverDraft());
            } else if (bankAccount instanceof SavingAccount) {
                System.out.println("Rate=>" + ((SavingAccount) bankAccount).getInterestRate());
            }
            bankAccount.getAccountOperations().forEach(op -> {
                System.out.println(op.getType() + "\t" + op.getOperationDate() + "\t" + op.getAmount());
            });
        }
    }
}
