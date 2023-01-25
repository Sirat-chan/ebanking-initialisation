package com.example.ebankinginitialisation.dtos;


import com.example.ebankinginitialisation.enums.AccountStatus;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Data
public class CurrentBankAccountDTO extends BankAccountDTO {
    @Id
    private String id;
    private Double balance;
    private Date createdAt;
    private AccountStatus status;
    private CustomerDTO customerDTO;
   private double overDraft;

}
