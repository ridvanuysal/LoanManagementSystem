package com.loancase.loanmanagementsystem;

import com.loancase.loanmanagementsystem.entity.Customer;
import com.loancase.loanmanagementsystem.entity.Loan;
import com.loancase.loanmanagementsystem.entity.LoanInstallment;
import com.loancase.loanmanagementsystem.repository.CustomerRepository;
import com.loancase.loanmanagementsystem.repository.LoanInstallmentRepository;
import com.loancase.loanmanagementsystem.repository.LoanRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Transactional
public class LoanInstallmentRepositoryList {

    @Autowired
    private LoanInstallmentRepository loanInstallmentRepository;

    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void testListLoanInstallments(){
        Customer customer = new Customer();
        customer.setName("Ridvan");
        customer.setSurname("test");
        customer.setCreditLimit(1000.0);
        customerRepository.save(customer);

        Loan loan = new Loan();
        loan.setCustomer(customer);
        loan.setLoanAmount(2000.0);
        loan.setNumberOfInstallment(9);
        loan.setCreateDate(LocalDate.now());
        loanRepository.save(loan);
        List<LoanInstallment> list = loanInstallmentRepository.findByLoan (loan);
        assertThat(list).isNotNull();
    }
}

