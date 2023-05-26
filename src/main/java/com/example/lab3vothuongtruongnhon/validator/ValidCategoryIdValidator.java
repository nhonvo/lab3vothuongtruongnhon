package com.example.lab3vothuongtruongnhon.validator;

import com.example.lab3vothuongtruongnhon.entity.Category;
import com.example.lab3vothuongtruongnhon.validator.annotation.ValidCategoryId;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidCategoryIdValidator implements ConstraintValidator<ValidCategoryId, Category> {
    @Override
    public boolean isValid(Category category, ConstraintValidatorContext constraintValidatorContext) {
        return category != null && category.getId() != null;
    }
}
