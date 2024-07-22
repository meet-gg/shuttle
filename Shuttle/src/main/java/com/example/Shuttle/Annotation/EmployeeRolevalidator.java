package com.example.Shuttle.Annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.List;

public class EmployeeRolevalidator implements ConstraintValidator<EmployeevalidRole,String> {
    @Override
    public boolean isValid(String inputrole, ConstraintValidatorContext constraintValidatorContext) {
        List<String> role=List.of("USER","ADMIN");
        return role.contains(inputrole);
    }
}
