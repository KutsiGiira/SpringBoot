package com.example.Securityv2.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginPage {
    @GetMapping("/myLogin")
    public String log(){
        return "myLogin";
    }
}
