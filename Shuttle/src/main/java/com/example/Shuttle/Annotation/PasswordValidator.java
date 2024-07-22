package com.example.Shuttle.Annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.ArrayList;

public class PasswordValidator implements ConstraintValidator<Password,String> {
    @Override
    public boolean isValid(String password, ConstraintValidatorContext constraintValidatorContext) {
        boolean flag=false;
        boolean flag1=false;
        boolean flag2=false;
        boolean flag3=false;
        for (int i=0;i<password.length();i++){
            if (Character.isLowerCase(password.charAt(i))){
                flag=true;
            }
            else if (Character.isUpperCase(password.charAt(i))){
                flag1=true;
            }
            else if (Character.isDigit(password.charAt(i))){
                flag3=true;
            }
            else {
                flag2=true;
            }
            if (flag2 && flag && flag1 && flag3){
                return true;
            }
        }
        return false;
    }
}
