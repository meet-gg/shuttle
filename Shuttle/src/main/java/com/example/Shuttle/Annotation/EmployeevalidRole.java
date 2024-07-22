package com.example.Shuttle.Annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {EmployeeRolevalidator.class})
public @interface EmployeevalidRole {
    String message() default "Role of the employee can be USER ADMIN";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
