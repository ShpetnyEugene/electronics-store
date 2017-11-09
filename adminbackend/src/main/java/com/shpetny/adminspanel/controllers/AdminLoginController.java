package com.shpetny.adminspanel.controllers;

import com.shpetny.backendusers.models.User;
import com.shpetny.backendusers.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/admin/login")
public class AdminLoginController {

    private final UserService userService;

    @Autowired
    @Qualifier("customUserDetailsService")
    private UserDetailsService userDetailsService;

    @Autowired
    public AdminLoginController(UserService userService) {
        this.userService = userService;
    }

    @ResponseBody
    @PostMapping
    public boolean login(@RequestBody User user, HttpServletRequest request) {
        if (userService.checkUserByLoginPasswordRole(user.getLogin(), user.getPassword())) {
            UserDetails userDetails = userDetailsService.loadUserByUsername(user.getLogin());
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            return true;
        } else {
            return false;
        }
    }
}
