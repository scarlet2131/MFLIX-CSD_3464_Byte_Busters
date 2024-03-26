package com.example.movierental.controllers;

import com.example.movierental.dto.UserDTO;
import com.example.movierental.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RegisterController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String registerUser(@Valid UserDTO userDTO, BindingResult result, RedirectAttributes redirectAttributes, Model model) {
        if (result.hasErrors()) {
            // Handle errors, potentially return to the registration form with error messages
            return "register";
        }

        try {
            userService.registerUser(userDTO);
            redirectAttributes.addFlashAttribute("successMessage", "Successfully registered!");
            return "login";
        } catch (IllegalStateException e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "register"; // Stay on the registration page and show error
        }
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        if (!model.containsAttribute("userDTO")) {
            model.addAttribute("userDTO", new UserDTO());
        }
        return "register";
    }
}
