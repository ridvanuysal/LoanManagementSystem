package com.loancase.loanmanagementsystem.service;

import com.loancase.loanmanagementsystem.entity.Loan;
import com.loancase.loanmanagementsystem.entity.LoanInstallment;
import com.loancase.loanmanagementsystem.exception.BusinessLogicException;
import com.loancase.loanmanagementsystem.exception.RecordNotFoundException;
import com.loancase.loanmanagementsystem.param.PayLoanResponse;
import com.loancase.loanmanagementsystem.repository.LoanInstallmentRepository;
import com.loancase.loanmanagementsystem.repository.LoanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LoanInstallmentService {
    private final LoanInstallmentRepository loanInstallmentRepository;
    private final LoanRepository loanRepository;

    public List<LoanInstallment> getLoanInstallments(Long loanId){
        Loan loan = loanRepository.findById(loanId)
                .orElseThrow(() ->  new RuntimeException("Credit info not found"));
        return loanInstallmentRepository.findByLoan(loan);
    }
    //List<LoanInstallment>
    public PayLoanResponse payLoanInstallments(Long loanId, Double paymentAmount){
        Loan loan = loanRepository.findById(loanId)
                .orElseThrow(() ->  new RecordNotFoundException("Credit info not found"));

        if(loan.isPaid()){
            throw new BusinessLogicException("Credit has already been paid");
        }

        LocalDate currentDate = LocalDate.now();
        LocalDate threeMonthsLater = currentDate.plusMonths(3);

        List<LoanInstallment> list = loanInstallmentRepository.
                findByLoanIdAndIsPaidFalseAndDueDateBeforeOrderByDueDate(loan.getId(),threeMonthsLater);

        double remainingAmount = paymentAmount;
        int paidInstallments = 0;
        double totalSpent = 0;

        for (LoanInstallment installment : list) {
            if (remainingAmount >= installment.getAmount()) {
                remainingAmount -= installment.getAmount();
                installment.setPaidAmount(installment.getAmount());
                installment.setPaid(true);
                installment.setPaymentDate(currentDate);
                totalSpent += installment.getAmount();
                paidInstallments++;
            } else {
                break;
            }
        }

        loanInstallmentRepository.saveAll(list);

        boolean allPaid = loanInstallmentRepository
                .findByLoanIdAndIsPaidFalseAndDueDateBeforeOrderByDueDate(loanId, threeMonthsLater)
                .isEmpty();

        if (allPaid) {
            loan.setPaid(true);
            loanRepository.save(loan);
        }

        PayLoanResponse response = new PayLoanResponse();
        response.setLoanId(loanId);
        response.setPaidInstallments(paidInstallments);
        response.setTotalPaidAmount(totalSpent);
        response.setPaidCompletely(allPaid);

        return response;
    }
}
