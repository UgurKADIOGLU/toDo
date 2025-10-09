package com.toDo.user.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class UserResponseDTO {
    private Long id;
    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private Boolean active;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
