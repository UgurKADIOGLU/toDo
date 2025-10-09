package com.toDo.user.dto;

import com.toDo.user.User;
import com.toDo.user.validation.UniqueEmail;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * DTO for creating new users
 */
@Data
public class UserCreate {

    @NotBlank(message = "{hoxify.constraint.username.notblank}")
    @Size(min = 4, max = 100, message = "Username must be between 4 and 100 characters")
    private String username;

    @Email(message = "Email should be valid")
    @NotBlank(message = "Email cannot be empty")
    @UniqueEmail
    private String email;

    @NotBlank(message = "Password cannot be empty")
    @Size(min = 6, message = "Password must be at least 6 characters")
    private String password;

    @Size(max = 50, message = "First name cannot be longer than 50 characters")
    private String firstName;

    @Size(max = 50, message = "Last name cannot be longer than 50 characters")
    private String lastName;

    public User toUser() {
        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);
        user.setFirstName(firstName);
        user.setLastName(lastName);        // Set default values for new user
        user.setActive(false);


        return user;
    }
}
