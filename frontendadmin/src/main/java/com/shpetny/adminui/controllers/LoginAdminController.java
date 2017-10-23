package com.shpetny.adminui.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/login")
public class LoginAdminController {

    @GetMapping
    public String showLoginAdmin(){
        return "loginAdmin";
    }
}
