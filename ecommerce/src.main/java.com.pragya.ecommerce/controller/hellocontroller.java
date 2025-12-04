package com.vishalkumar.ecommerce.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello() {
        return "Welcome, User on Smart E-commerce platform !";
    }
}
