package com.example.lab3vothuongtruongnhon.validator;

import com.example.lab3vothuongtruongnhon.repository.IUserRepository;
import com.example.lab3vothuongtruongnhon.validator.annotation.ValidUsername;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class ValidUsernameValidator implements ConstraintValidator<ValidUsername, String> {
    @Autowired
    private IUserRepository userRepository;

    @Override
    public boolean isValid(String username, ConstraintValidatorContext constraintValidatorContext) {
        if (userRepository == null)
            return true;
        return userRepository.findByUsername(username) == null;
    }
}
