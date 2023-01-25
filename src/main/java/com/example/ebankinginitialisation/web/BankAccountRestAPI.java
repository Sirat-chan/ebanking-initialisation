package com.example.ebankinginitialisation.web;

import com.example.ebankinginitialisation.dtos.AccountHistoryDTO;
import com.example.ebankinginitialisation.dtos.AccountOperationDTO;
import com.example.ebankinginitialisation.dtos.BankAccountDTO;
import com.example.ebankinginitialisation.exceptions.BankAccountNotFoundException;
import com.example.ebankinginitialisation.services.BankAccountService;
import com.mysql.management.util.Str;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin("*")
public class BankAccountRestAPI {

    private BankAccountService bankAccountService;

    public BankAccountRestAPI(BankAccountService bankAccountService){
        this.bankAccountService = bankAccountService;
    }

    @GetMapping("/accounts/{accountId}")
    public BankAccountDTO getBankAccount(@PathVariable String accountId) throws BankAccountNotFoundException {
            return bankAccountService.getBankAccount(accountId);
    }
    @GetMapping("/accounts")
    public List<BankAccountDTO> ListAccounts(){
        return bankAccountService.bankAccountList();
    }
    @GetMapping("/accounts/{accountId}/operations")
    public List<AccountOperationDTO> getHistory(@PathVariable String accountId){
        return bankAccountService.accountHistory(accountId);
    }

    @GetMapping("/accounts/{accountId}/pageOperations")
    public AccountHistoryDTO getHistory(@PathVariable String accountId,
                                        @RequestParam(name = "page", defaultValue = "0") int page,
                                        @RequestParam(name = "size", defaultValue = "5") int size) throws BankAccountNotFoundException {
        return bankAccountService.getAccountHistory(accountId,page,size);
    }
}
