package com.loancase.loanmanagementsystem.controller;

import com.loancase.loanmanagementsystem.entity.LoanInstallment;
import com.loancase.loanmanagementsystem.param.PayLoanResponse;
import com.loancase.loanmanagementsystem.service.LoanInstallmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class LoanInstallmentController {

    private final LoanInstallmentService loanInstallmentService;

    @GetMapping("/user/installments")
    public List<LoanInstallment> listLoanInstallments(@RequestParam Long loanId){
        return loanInstallmentService.getLoanInstallments(loanId);
    }

    @PutMapping("/admin/pay-installment")
    public ResponseEntity<PayLoanResponse> payLoanInstallments(@RequestParam Long loanId, @RequestParam Double tutar){
        PayLoanResponse response = loanInstallmentService.payLoanInstallments(loanId,tutar);
        return ResponseEntity.ok(response);
    }
}
