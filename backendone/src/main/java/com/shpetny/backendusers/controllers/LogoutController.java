package com.shpetny.backendusers.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/users/logout")
public class LogoutController {

    @GetMapping
    public void logoutUser(HttpSession httpSession){
        httpSession.removeAttribute("userId");
    }
}
