package com.example.movierental.controllers;

import com.example.movierental.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {

    @Autowired
    private UserService userService; // Assume this service has the method to check email

    @PostMapping("/check-email")
    public String checkEmail(@RequestParam("email") String email, RedirectAttributes redirectAttributes) {
        boolean exists = userService.existsByEmail(email);

        if (exists) {
            // If email exists, redirect to login with email prefilled (optional)
            redirectAttributes.addFlashAttribute("email", email);
            return "redirect:/login";
        } else {
            // If email doesn't exist, redirect to registration with email prefilled (optional)
            redirectAttributes.addFlashAttribute("email", email);
            return "redirect:/register";
        }
    }
}
