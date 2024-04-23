package com.gcu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        // You can add any model attributes if needed
        // For example: model.addAttribute("title", "Welcome to my website");
        // Testing comments out
        
        System.out.println("Here");
        return "home"; // This assumes you have a "home.html" Thymeleaf template
    }
}
