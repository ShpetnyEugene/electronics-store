package com.shpetny.backendusers.controllers;

import com.shpetny.backendusers.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * @author Shpetny Eugene
 * @version 1.0
 */
@Controller
@RequestMapping("/users/registration")
public class RegistrationController {

    private final UserService userService;

    @Autowired
    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public void registerUser(@RequestParam("login") String login,
                             @RequestParam("password") String password) {
        userService.createUser(login, password);
    }
}
