package com.nguyenducmanh.Validator;

import com.nguyenducmanh.annotation.Camera;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CameraValidator implements ConstraintValidator<Camera, String> {
    private static final String endsWith = "MP";

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.isEmpty()) return false;

        return value.endsWith(endsWith);
    }
}
