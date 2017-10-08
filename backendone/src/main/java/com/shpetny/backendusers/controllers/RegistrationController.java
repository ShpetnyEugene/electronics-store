package com.shpetny.backendusers.controllers;

import com.shpetny.backendusers.models.User;
import com.shpetny.backendusers.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * @author Shpetny Eugene
 * @version 1.0
 */
@RestController
@RequestMapping("/users/registration")
public class RegistrationController {

    private final UserService userService;

    @Autowired
    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User registerUser(@RequestBody User user) {
        userService.createUser(user.getLogin(), user.getPassword());
        return user;
    }
}
