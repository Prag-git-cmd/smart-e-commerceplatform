package com.vishalkumar.ecommerce.controller;

import com.vishalkumar.ecommerce.model.UserDto;
import com.vishalkumar.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("userDto") UserDto userDto, Model model) {
        try {
            userService.registerUser(userDto);
            return "redirect:/login";
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Email already registered!");
            return "register";
        }
    }
}
