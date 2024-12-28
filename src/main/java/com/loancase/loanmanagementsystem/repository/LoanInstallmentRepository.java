package com.loancase.loanmanagementsystem.repository;

import com.loancase.loanmanagementsystem.entity.Loan;
import com.loancase.loanmanagementsystem.entity.LoanInstallment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface LoanInstallmentRepository extends JpaRepository<LoanInstallment, Long> {

    List<LoanInstallment> findByLoan(Loan loan);
    List<LoanInstallment> findByLoanIdAndIsPaidFalseAndDueDateBeforeOrderByDueDate(Long loanId, LocalDate dueDate);
}
