package com.example.Shuttle.Annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class primenumbervalidator implements ConstraintValidator<Primenumber,Integer> {
    @Override
    public boolean isValid(Integer number, ConstraintValidatorContext constraintValidatorContext) {
        boolean flag=true;
        for (int i=2;i<Math.sqrt(number);i++){
            if (number%i==0){
                flag=!flag;
                break;
            }
        }
        if (flag){
            return true;
        }
        return false;
    }
}
