package com.shpetny.backendusers.controllers;

import com.shpetny.backendusers.models.User;
import com.shpetny.backendusers.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/users/login")
public class LoginController {

    private final UserService userService;

    @Autowired
    @Qualifier("customUserDetailsService")
    private UserDetailsService userDetailsService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    @ResponseBody
    public String login(@RequestBody User user, HttpServletRequest request) {
        // TODO Check
        if (!userService.checkUserByLoginAndPassword(user.getLogin(), user.getPassword())) {
            UserDetails userDetails = userDetailsService.loadUserByUsername(user.getLogin());
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            return "redirect:http://localhost:8091/home";
        }else {
            return "login";
        }

    }

}
