package com.toDo.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "hoaxify")
@Configuration
public class HoaxifyProperties {


    private Email email;

    public static record Email(String username){

    }
    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }
}
