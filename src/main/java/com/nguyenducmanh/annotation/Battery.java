package com.nguyenducmanh.annotation;

import com.nguyenducmanh.Validator.BatteryValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = BatteryValidator.class)
@Retention(RUNTIME)
@Target({ FIELD, METHOD })
public @interface Battery {
	
	String message() default "Vui lòng nhập dung lượng pin + mAh";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
