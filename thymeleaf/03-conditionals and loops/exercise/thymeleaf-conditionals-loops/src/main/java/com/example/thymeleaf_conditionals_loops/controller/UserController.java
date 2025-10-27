package com.example.thymeleaf_conditionals_loops.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class UserController {
    @GetMapping("/users")
    public String showUsers(Model model){
        List<String> users = Arrays.asList("Alice","Bob","Charlie");

        model.addAttribute("users",users);
        model.addAttribute("isAdmin",true);
        model.addAttribute("role","ADMIN");
        
        return "user-list";
    }
}
