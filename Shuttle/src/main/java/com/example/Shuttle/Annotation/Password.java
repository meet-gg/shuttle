package com.example.Shuttle.Annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {PasswordValidator.class})
public @interface Password {
    String message() default "password contains one uppercase   "+
                             "password contains one lowercase    "+
                                "password contains one specialcharacter    " +
                                "password contains one digit";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
