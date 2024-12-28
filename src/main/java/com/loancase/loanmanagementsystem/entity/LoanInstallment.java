package com.loancase.loanmanagementsystem.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class LoanInstallment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Loan loan;
    private Double amount;
    private Double paidAmount = 0.0;
    private LocalDate dueDate;
    private LocalDate paymentDate;
    private boolean isPaid = false;
}
