package com.example.Thymleaf.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Movie {


    @GetMapping("/main")
    public String main(){
        return "mainp";
    }
    @GetMapping("/form")
    public String form(@RequestParam String name){
        return "formp";
    }
}
