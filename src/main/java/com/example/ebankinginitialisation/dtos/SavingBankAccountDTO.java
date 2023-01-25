package com.example.ebankinginitialisation.dtos;


import com.example.ebankinginitialisation.enums.AccountStatus;
import jakarta.persistence.*;

import lombok.Data;


import java.util.Date;
import java.util.List;

@Data
public class SavingBankAccountDTO extends BankAccountDTO {
    @Id
    private String id;
    private Double balance;
    private Date createdAt;
    private AccountStatus status;
    private CustomerDTO customerDTO;
   private double interestRate;

}
