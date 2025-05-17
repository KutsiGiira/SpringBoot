package com.example.SpringAuth.Controllers;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Main {
    @GetMapping("/main")
    public String home(HttpSession session){
        return "Main Page "  + session.getId();
    }
}
