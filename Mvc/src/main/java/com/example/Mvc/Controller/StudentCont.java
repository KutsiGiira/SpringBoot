package com.example.Mvc.Controller;

import com.example.Mvc.Model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentCont {
    @GetMapping("/list")
    public String showList(Model model){
        Student s = new Student();
        model.addAttribute("values", s);
        return "List";
    }
    @PostMapping("/ShowList")
    public String pForm(@ModelAttribute("s") Student s){
        System.out.println(s.getFirstN() + " " + s.getLastN() + " " + s.getCountry());
        return "ShowList";
    }

}