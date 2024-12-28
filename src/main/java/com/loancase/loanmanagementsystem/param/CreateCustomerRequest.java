package com.loancase.loanmanagementsystem.param;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class CreateCustomerRequest {

    @NotNull(message = "Name is required")
    @NotBlank(message = "Name cannot be blank")
    private String name;

    @NotNull(message = "Surname is required")
    @NotBlank(message = "Surname cannot be blank")
    private String surname;

    @NotNull(message = "Credit Limit  is required")
    private Double  creditLimit;

    private Double usedCredit= 0.0;
}
