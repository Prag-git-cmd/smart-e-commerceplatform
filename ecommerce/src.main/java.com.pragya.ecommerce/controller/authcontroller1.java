package com.vishalkumar.ecommerce.controller;

import com.vishalkumar.ecommerce.model.LoginDto;
import com.vishalkumar.ecommerce.model.User;
import com.vishalkumar.ecommerce.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("login", new LoginDto());
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("login") LoginDto loginDto, Model model, HttpSession session) {
        User user = userService.validateLogin(loginDto.getEmail(), loginDto.getPassword());
        if (user != null) {
            session.setAttribute("user", user);
            return "redirect:/dashboard";
        } else {
            model.addAttribute("errorMessage", "Invalid email or password");
            return "login";
        }
    }
}
