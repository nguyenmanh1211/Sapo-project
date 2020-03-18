package com.nguyenducmanh.Validator;

import com.nguyenducmanh.annotation.Memory;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MemoryValidator implements ConstraintValidator<Memory, String> {
    private static final String endsWith = "GB";

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.isEmpty()) return false;

        return value.endsWith(endsWith);
    }
}
