package com.shpetny.useriu.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MultipurposeController {

    @Value("${app.backend.url}")
    private String string;

    @GetMapping("/home")
    public String showHomePage(Model model) {
        model.addAttribute("backendUrl", string);
        return "home";
    }

    @GetMapping("/users/login")
    public String showLoginPage(Model model) {
        model.addAttribute("url", string);
        return "login";
    }

    @GetMapping("/users/cart")
    public String showCartPage() {
        return "cart";
    }


    @GetMapping("/users/registration")
    public String showRegistrationPage(Model model) {
        model.addAttribute("backendUrl", string);
        return "registration";
    }

    @GetMapping("/products")
    public String showProductsPage(Model model) {
        model.addAttribute("backendUrl",string);
        return "products";
    }

    @GetMapping("/users/purchases")
    public String showPurchasesPage() {
        return "purchases";
    }

    @GetMapping("/products/{productName}")
    public String showDefiniteProductsPage(@PathVariable String productName, Model model) {
        model.addAttribute("productName", productName);
        model.addAttribute("backendUrl", string);
        return "product";
    }

}
