package com.loancase.loanmanagementsystem.validator;

import com.loancase.loanmanagementsystem.constants.ValidIntValues;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;

public class ValidIntValuesValidator implements ConstraintValidator<ValidIntValues, Integer> {

    private int[] allowedValues;

    @Override
    public void initialize(ValidIntValues constraintAnnotation) {
        this.allowedValues = constraintAnnotation.allowedValues();
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        if (value == null) {
            return true; // Null değer kontrolü ayrı yapılabilir
        }
        return Arrays.stream(allowedValues).anyMatch(allowedValue -> allowedValue == value);
    }
}

