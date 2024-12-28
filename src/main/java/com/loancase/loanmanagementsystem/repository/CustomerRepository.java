package com.loancase.loanmanagementsystem.repository;

import com.loancase.loanmanagementsystem.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
