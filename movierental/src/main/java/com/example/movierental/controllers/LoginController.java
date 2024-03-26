package com.example.movierental.controllers;

import com.example.movierental.dto.login.UserLoginDTO;
import com.example.movierental.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public String login(UserLoginDTO userLoginDTO, Model model) {
        if (userService.authenticateUser(userLoginDTO)) {
            // If login is successful, redirect to a success page or home page
            return "index"; // Adjust the redirect as necessary
        } else {
            // Add error message to model and return to login page
            model.addAttribute("loginError", true);
            return "login";
        }
    }

    @GetMapping("/login")
    public String showLoginPage(Model model) {
        return "login";
    }
}
