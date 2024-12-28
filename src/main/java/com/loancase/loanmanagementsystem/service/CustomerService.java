package com.loancase.loanmanagementsystem.service;

import com.loancase.loanmanagementsystem.entity.Customer;
import com.loancase.loanmanagementsystem.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public Customer createCustomer(String name,String surname,Double creditLimit,Double usedCredit){
        Customer customer = new Customer();
        customer.setCreditLimit(creditLimit);
        customer.setName(name);
        customer.setSurname(surname);
        customer.setUsedCreditLimit(usedCredit);
        customerRepository.save(customer);
        return customer;
    }
}
