package com.toDo.user;

import com.toDo.user.validation.UniqueEmail;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    Boolean active;

    String activationToken;

    @Column()
    @NotBlank(message = "{hoxify.constraint.username.notblank}")
    private String username;


    private String email;


    private String password;


    private String firstName;


    private String lastName;


    private LocalDateTime createdAt;


    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
