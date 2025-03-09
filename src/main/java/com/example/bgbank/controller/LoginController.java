package com.example.bgbank.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String showLoginPage(Model model) {
        return "login"; // Points to login.html in templates folder
    }
    @GetMapping("/forgot-password")
    public String displayForgotPass(Model model) {
        return "forgot-password"; // Points to login.html in templates folder
    }
}
