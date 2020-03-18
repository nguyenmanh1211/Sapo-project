package com.nguyenducmanh.annotation;

import com.nguyenducmanh.Validator.MemoryValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = MemoryValidator.class)
@Retention(RUNTIME)
@Target({ FIELD, METHOD })
public @interface Memory {

    String message() default "Vui lòng nhập bộ nhớ + GB";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
