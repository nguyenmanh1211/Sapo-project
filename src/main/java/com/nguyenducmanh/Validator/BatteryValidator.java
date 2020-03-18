package com.nguyenducmanh.Validator;

import com.nguyenducmanh.annotation.Battery;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class BatteryValidator implements ConstraintValidator<Battery, String> {
    private static final String endsWith = "mAh";

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.isEmpty()) return false;

        return value.endsWith(endsWith);
    }
}
