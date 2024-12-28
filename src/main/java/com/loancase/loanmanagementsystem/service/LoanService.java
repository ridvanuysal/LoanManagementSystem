package com.loancase.loanmanagementsystem.service;

import com.loancase.loanmanagementsystem.entity.Customer;
import com.loancase.loanmanagementsystem.entity.Loan;
import com.loancase.loanmanagementsystem.entity.LoanInstallment;
import com.loancase.loanmanagementsystem.repository.CustomerRepository;
import com.loancase.loanmanagementsystem.repository.LoanInstallmentRepository;
import com.loancase.loanmanagementsystem.repository.LoanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LoanService {

    private final CustomerRepository customerRepository;
    private final LoanRepository loanRepository;
    private final LoanInstallmentRepository loanInstallmentRepository;

    public Loan createLoan(Long customerId, Double amount, Double interestRate, Integer installments){

        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        if(customer.getUsedCreditLimit() + amount > customer.getCreditLimit()){
            throw new RuntimeException("Credit Limit exceed");
        }

        Loan loan = new Loan();
        loan.setCustomer(customer);
        loan.setLoanAmount(amount);
        loan.setNumberOfInstallment(installments);
        loan.setCreateDate(LocalDate.now());
        loanRepository.save(loan);

        Double totalAmount = amount * (1 + interestRate);
        Double installmentAmount = totalAmount / installments;
        for(int i=0; i< installments; i++){
            LoanInstallment installment = new LoanInstallment();
            installment.setLoan(loan);
            installment.setAmount(installmentAmount);
            installment.setDueDate(LocalDate.now().plusMonths(i).withDayOfMonth(1));
            loanInstallmentRepository.save(installment);
        }

        customer.setUsedCreditLimit(customer.getUsedCreditLimit() + amount);
        customerRepository.save(customer);
        return loan;
    }

    public List<Loan> getLoans(Long customerId){
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        return loanRepository.findByCustomer(customer);
    }


}
