package com.example.ebankinginitialisation.dtos;

import lombok.Data;

@Data
public class TransferRequestDTO {
    private String accountSource;
    private String accountDestination;
    private double amount;

}
