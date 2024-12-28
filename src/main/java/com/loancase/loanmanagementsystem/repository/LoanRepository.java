package com.loancase.loanmanagementsystem.repository;

import com.loancase.loanmanagementsystem.entity.Customer;
import com.loancase.loanmanagementsystem.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoanRepository extends JpaRepository<Loan,Long> {
    List<Loan> findByCustomer(Customer customer);
}
