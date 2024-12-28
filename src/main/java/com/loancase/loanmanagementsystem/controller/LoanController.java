package com.loancase.loanmanagementsystem.controller;

import com.loancase.loanmanagementsystem.service.LoanService;
import com.loancase.loanmanagementsystem.entity.Loan;
import com.loancase.loanmanagementsystem.param.CreateLoanRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class LoanController {
    private final LoanService loanService;

    @PostMapping("/admin/loans")
    public ResponseEntity<Loan> createLoan(@Valid @RequestBody CreateLoanRequest request){
        Loan loan = loanService.createLoan(request.getCustomerId(),request.getAmount(),
                request.getInterestRate(), request.getInstallments());
        return  ResponseEntity.ok(loan);
    }

    @GetMapping("/user/list-loans")
    public List<Loan> listLoans(@RequestParam Long customerId){
        return loanService.getLoans(customerId);
    }


}
