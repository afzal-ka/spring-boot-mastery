package com.thymeleaf.thymeleaf_1.controller;

import com.thymeleaf.thymeleaf_1.model.UserForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class FormController {

    @GetMapping("/register")
    public String userRegistrationPage(Model model){
        UserForm userForm = new UserForm();
        model.addAttribute("userForm",userForm);

        List<String> profession = Arrays.asList("Developer","Tester","Architect");
        model.addAttribute("professions",profession);

        return "register-form";
    }
}
