package com.loancase.loanmanagementsystem;

import com.loancase.loanmanagementsystem.entity.Customer;
import com.loancase.loanmanagementsystem.entity.Loan;
import com.loancase.loanmanagementsystem.repository.CustomerRepository;
import com.loancase.loanmanagementsystem.repository.LoanRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Transactional
public class LoanRepositoryTest {

    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void testCreateLoan(){
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

        Loan savedLoan = loanRepository.findById(loan.getId()).orElse(null);
        assertThat(savedLoan).isNotNull();
        assertThat(savedLoan.getLoanAmount()).isEqualTo(2000.0);

    }
}
