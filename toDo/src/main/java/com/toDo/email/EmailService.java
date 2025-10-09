package com.toDo.email;

import com.toDo.configuration.HoaxifyProperties;
import com.toDo.user.User;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
public class EmailService {



    @Autowired
    HoaxifyProperties hoaxifyProperties;

    JavaMailSenderImpl mailSender;

    @PostConstruct
    public void InitialMailSender() {
        this.mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.ethereal.email");
        mailSender.setPort(587);
        mailSender.setUsername(hoaxifyProperties.getEmail().username());
        mailSender.setPassword("C5STpbtRb3zBwPHZuU");
        Properties properties = mailSender.getJavaMailProperties();
        properties.put("mail.smtp.starttls.enable", "true");

    }

    public void sendActivationEmail(String email, String activationToken) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("info@my-app.email");
        mailMessage.setTo(email);
        mailMessage.setSubject("Hoxify Activation Email");
        mailMessage.setText("http:localhost:5173/activation/" + activationToken);
        this.mailSender.send(mailMessage);

    }
}
