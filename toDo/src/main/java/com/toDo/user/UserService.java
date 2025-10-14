package com.toDo.user;

import com.toDo.email.EmailService;
import com.toDo.user.exception.ActivationEmailException;
import com.toDo.user.exception.InvalidTokenException;
import com.toDo.user.exception.NotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.mail.MailException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    EmailService emailService;

    @Transactional(rollbackOn = MailException.class)
    public void save(User user) {
        try {
            user.setActivationToken(UUID.randomUUID().toString());
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            emailService.sendActivationEmail(user.getEmail(),user.getActivationToken());
            userRepository.saveAndFlush(user);
        } catch (MailException ex){
            throw new ActivationEmailException();
        }

    }


    public void activateUser(String token) {
        User user = userRepository.findByActivationToken(token);
        if(user == null){
            throw new InvalidTokenException();
        }
        user.setActive(true);
        user.setActivationToken(null);
        userRepository.saveAndFlush(user);
    }

    public Page<User> findAll(Pageable pageable) {
       return userRepository.findAll(pageable);
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }
}
