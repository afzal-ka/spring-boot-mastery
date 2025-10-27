package com.example.thymeleafbasics.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class BasicController {

    @GetMapping("/syntax")
    public String showSyntax(Model model){
        model.addAttribute("name","Learner");
        model.addAttribute("isActive",true);
        model.addAttribute("items", List.of("Item 1","Item 2","Item 3"));
        model.addAttribute("isAdmin",true);
        return "syntax";
    }
}
