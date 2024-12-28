package com.loancase.loanmanagementsystem.param;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PayLoanResponse {

    private Long loanId;
    private int paidInstallments;
    private double totalPaidAmount;
    private boolean isPaidCompletely;
}
