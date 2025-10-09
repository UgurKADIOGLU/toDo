package com.toDo.user.validation;

import com.toDo.user.User;
import com.toDo.user.UserRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail,String> {
    @Autowired
    UserRepository userRepository;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        User user = userRepository.findByEmail(value);
       return user == null;
    }
}
