package com.toDo.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController()
@RequestMapping("/api/v1")
public class UserController {
    @Autowired
    UserRepository userRepository;

    @PostMapping("/users")
    User getUser(@RequestBody User user) {
        userRepository.save(user);

        return user;
    }
}
