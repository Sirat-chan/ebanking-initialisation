package com.example.ebankinginitialisation.dtos;

import com.example.ebankinginitialisation.entities.BankAccount;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mysql.management.util.Str;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
public class CustomerDTO {
    private Long id;
    private String name;
    private String email;

}
