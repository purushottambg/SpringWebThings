package com.week2WebApplication.SpringWebThings.CustomAnnotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.List;

public class CheckDepts implements ConstraintValidator<DecideDept, String> {
    @Override
    public boolean isValid(String department, ConstraintValidatorContext constraintValidatorContext) {
        List<String> Departmemts = List.of("IT", "Finance", "Family", "HealthCare", "Investors");
        return Departmemts.contains(department);
    }
}
