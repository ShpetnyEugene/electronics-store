package com.shpetny.adminui.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminPanelController {

    @Value("${app.backend}")
    private String url;

    @GetMapping("/admin")
    public String showAdminPanel(Model model){
        model.addAttribute("url",url);
        return "admin";
    }
}
