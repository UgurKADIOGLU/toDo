package com.toDo.user;

import com.toDo.email.EmailService;
import com.toDo.user.exception.ActivationEmailException;
import com.toDo.user.exception.InvalidTokenException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Properties;
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

    public List<User> findAll() {
       return userRepository.findAll();
    }
}
