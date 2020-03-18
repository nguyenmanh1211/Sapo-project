package com.nguyenducmanh.Validator;


import com.nguyenducmanh.annotation.Price;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PriceValidator implements ConstraintValidator<Price, Integer> {

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        if (value < 0 || value == null) return false;
        return true;
    }
}
