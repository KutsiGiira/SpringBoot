package com.example.Securityv2.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Cont {
    @GetMapping("/")
    public String homePage(){
        return "home";
    }
    @GetMapping("/admin")
    public String Admin(){
        return "admin";
    }
}