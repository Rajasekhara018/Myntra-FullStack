package com.myntra.controller;

import com.myntra.model.AuthRegister;
import com.myntra.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;

@Controller
public class EmailController {

    @GetMapping("/registrationEmail")
    public String regitrationEmail(Model model){
        LocalDate today = LocalDate.now();
        User user = new User("Badam Rajasekhara Reddy", "rajshekarbadam001@gmail.com",today);
        model.addAttribute("user",user);
        return "RegitrationTemplate";
    }
}
