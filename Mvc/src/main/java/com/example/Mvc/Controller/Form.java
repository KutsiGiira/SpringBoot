package com.example.Mvc.Controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping
@Controller
public class Form {
    @RequestMapping("/form")
    public String showForm(){
        return "Form";
    }
    @RequestMapping("/helloworld")
    public String v1(@RequestParam("name") String name, Model m){
        name =name.toUpperCase();
        String n = "BIG " + name;
        m.addAttribute("msg", n);
        return "helloworld";
    }
}