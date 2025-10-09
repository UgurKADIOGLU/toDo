package com.toDo.user;

import com.toDo.error.ApiError;
import com.toDo.shared.GenericMessage;
import com.toDo.shared.Messages;
import com.toDo.user.dto.UserCreate;
import com.toDo.user.exception.ActivationEmailException;
import com.toDo.user.exception.InvalidTokenException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController()
@RequestMapping("/api/v1")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/users")
    GenericMessage createUser(@Valid @RequestBody UserCreate userCreate) {
        System.err.println(LocaleContextHolder.getLocale().getLanguage());

        userService.save(userCreate.toUser());
        String message = Messages.getMessagesForLocale("hoxify.create.user.success", LocaleContextHolder.getLocale());
        return new GenericMessage(message);
    }

    @PatchMapping("/users/{token}/active")
    GenericMessage activateUser(@PathVariable String token) {
        userService.activateUser(token);
        String message = Messages.getMessagesForLocale("hoxify.activate.user.success", LocaleContextHolder.getLocale());
        return new GenericMessage(message);
    }

    @GetMapping("/users")
    List<User> getAllUsers(){
        return userService.findAll();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    ResponseEntity<ApiError> handleValidationExceptions(MethodArgumentNotValidException ex) {
        ApiError apiError = new ApiError();
        apiError.setPath("/api/v1/users");
        apiError.setMessage("Validation Error");
        apiError.setStatus(400);
        Map<String, String> validationErrors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            validationErrors.put(error.getField(), error.getDefaultMessage());
        });
        apiError.setValidationErrors(validationErrors);
        return ResponseEntity.badRequest().body(apiError);
    }

    @ExceptionHandler(ActivationEmailException.class)
    ResponseEntity<ApiError> handleActivationEmailExceptio(ActivationEmailException ex) {
        ApiError apiError = new ApiError();
        apiError.setPath("/api/v1/users");
        apiError.setMessage(ex.getMessage());
        apiError.setStatus(502);
        return ResponseEntity.status(502).body(apiError);
    }

    @ExceptionHandler(InvalidTokenException.class)
    ResponseEntity<ApiError> invalidTokenException(InvalidTokenException ex) {
        ApiError apiError = new ApiError();
        apiError.setPath("/api/v1/users");
        apiError.setMessage(ex.getMessage());
        apiError.setStatus(400);
        return ResponseEntity.status(400).body(apiError);
    }
}


