package com.example.QuotesGen.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Page {
    @GetMapping("/main")
    public String mainPage(){
        return "main";
    }
}
