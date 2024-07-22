package com.example.Shuttle.Annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {primenumbervalidator.class})
public @interface Primenumber {
    String message() default "please enter prime number";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
