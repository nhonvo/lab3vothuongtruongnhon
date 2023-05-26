package com.example.lab3vothuongtruongnhon.validator;

import com.example.lab3vothuongtruongnhon.entity.User;
import com.example.lab3vothuongtruongnhon.validator.annotation.ValidUserId;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidUserIdValidator implements ConstraintValidator<ValidUserId, User> {
    @Override
    public boolean isValid(User user, ConstraintValidatorContext constraintValidatorContext) {
        if (user == null)
            return true;
        return user.getId() != null;
    }
}
