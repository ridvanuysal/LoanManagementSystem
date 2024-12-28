package com.loancase.loanmanagementsystem.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Customer customer;
    private Double loanAmount;
    private Integer numberOfInstallment;
    private LocalDate createDate;
    private boolean isPaid  = false;
}
