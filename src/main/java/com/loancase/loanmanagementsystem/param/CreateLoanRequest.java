package com.loancase.loanmanagementsystem.param;

import com.loancase.loanmanagementsystem.constants.ValidIntValues;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import lombok.Getter;
import jakarta.validation.constraints.NotNull;

@Getter
public class CreateLoanRequest {

    @NotNull(message = "Customer Id is required")
    private Long customerId;

    @NotNull(message = "Amount is required")
    private Double amount;

    @NotNull(message = "Installment is required")
    @ValidIntValues(allowedValues = {6,9,12,24}, message = "Loan installment number must be 6,9,12 or 24")
    private int installments;

    @NotNull(message = "Interest Rate is required")
    @DecimalMin(value="0.1", message = "min ")
    @DecimalMax(value="0.5", message = " max")
    private Double interestRate;

}
