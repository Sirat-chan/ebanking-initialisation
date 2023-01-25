package com.example.ebankinginitialisation.services;

import com.example.ebankinginitialisation.dtos.*;
import com.example.ebankinginitialisation.entities.BankAccount;
import com.example.ebankinginitialisation.entities.CurrentAccount;
import com.example.ebankinginitialisation.entities.Customer;
import com.example.ebankinginitialisation.entities.SavingAccount;
import com.example.ebankinginitialisation.exceptions.BalanceNotSufficientException;
import com.example.ebankinginitialisation.exceptions.BankAccountNotFoundException;
import com.example.ebankinginitialisation.exceptions.CustomerNotFoundException;
import com.mysql.management.util.Str;

import java.util.List;

public interface BankAccountService {
    CustomerDTO saveCustomer(CustomerDTO customerDTO);
    CurrentBankAccountDTO saveCurrentAccount(double initialBalance, double overDraft, Long customerId) throws CustomerNotFoundException;
    SavingBankAccountDTO saveSavingBankAccount(double initialBalance, double interestRate, Long customerId) throws CustomerNotFoundException;
    List<CustomerDTO> listCustomers();
    BankAccountDTO getBankAccount(String accountId) throws BankAccountNotFoundException;
    void debit (String accountId, double amount, String description) throws BankAccountNotFoundException, BalanceNotSufficientException;
    void credit(String accountId, double amount, String description) throws BankAccountNotFoundException;
    void transfer (String accountIdSource, String accountIdDescription, double amount) throws BankAccountNotFoundException, BalanceNotSufficientException;


    List<BankAccountDTO> bankAccountList();

    CustomerDTO getCustomer(Long customerId);

    CustomerDTO updateCustomer(CustomerDTO customerDTO);

    void deleteCustomer(Long customerId);

    List<AccountOperationDTO> accountHistory(String accountId);

    AccountHistoryDTO getAccountHistory(String accountId, int page, int size) throws BankAccountNotFoundException;

    List<CustomerDTO> searchCustomers(String keyword);
}
