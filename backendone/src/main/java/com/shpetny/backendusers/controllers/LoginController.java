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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
    public boolean login(@RequestBody User user, HttpServletRequest request, HttpSession httpSession) {
        if (userService.checkUserByLoginAndPassword(user.getLogin(), user.getPassword())) {
            UserDetails userDetails = userDetailsService.loadUserByUsername(user.getLogin());
            User userSession = userService.getByLogin(user.getLogin());
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            httpSession.setAttribute("userId", userSession.getId());
            return true;
        } else {
            return false;
        }
    }
}
