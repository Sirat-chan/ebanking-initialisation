package com.example.ebankinginitialisation.repositories;

import com.example.ebankinginitialisation.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository <Customer, Long> {

}
