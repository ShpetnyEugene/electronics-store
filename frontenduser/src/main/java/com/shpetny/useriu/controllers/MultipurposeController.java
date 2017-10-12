package com.shpetny.useriu.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MultipurposeController {

    @Value("${app.backend.url}")
    private String string;

    @Value("${app.admin.ui.url}")
    private String string1;


    @GetMapping("/admin")
    public String showHomePage(ModelAndView modelAndView) {
        modelAndView.addObject("adminUrl", string1);
        return "admin";
    }

    @GetMapping("/home")
    public String showHomePage() {
        return "home";
    }

    // Вход в систему
    @GetMapping("/users/login")
    public String showLoginPage() {
        return "login";
    }

    // Корзина покупок
    @GetMapping("/users/cart")
    public String showCartPage() {
        return "cart";
    }

    // Регистрация
    @GetMapping("/users/registration")
    public String showRegistrationPage(Model model) {
        model.addAttribute("backendUrl", string);
        return "registration";
    }

    // Список всех покупок
    @GetMapping("/products")
    public String showProductsPage() {
        return "products";
    }

    // Показать определенный продукт
    @GetMapping("/products/{productName}")
    public String showDefiniteProductsPage(@PathVariable String productName, Model model) {
        model.addAttribute("productName", productName);
        return "product";
    }

}
