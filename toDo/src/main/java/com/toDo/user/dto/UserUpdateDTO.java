package com.toDo.user.dto;

import com.toDo.user.validation.UniqueEmail;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserUpdateDTO {
    @Size(min = 4, max = 100, message = "Username must be between 4 and 100 characters")
    private String username;

    @Email(message = "Email should be valid")
    @UniqueEmail
    private String email;
    
    @Size(max = 50, message = "First name cannot be longer than 50 characters")
    private String firstName;
    
    @Size(max = 50, message = "Last name cannot be longer than 50 characters")
    private String lastName;
}
