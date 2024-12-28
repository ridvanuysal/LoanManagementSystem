package com.loancase.loanmanagementsystem.controller;

import com.loancase.loanmanagementsystem.entity.Customer;
import com.loancase.loanmanagementsystem.param.CreateCustomerRequest;
import com.loancase.loanmanagementsystem.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/admin/customers")
    public ResponseEntity<Customer> createCustomer(@Valid @RequestBody CreateCustomerRequest request){

        Customer customer = customerService.createCustomer(request.getName(), request.getSurname(),
                request.getCreditLimit(), request.getUsedCredit());
        return ResponseEntity.ok(customer);
    }
}
