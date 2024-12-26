package com.example.TODO.list.Controller;

import com.example.TODO.list.Model.Todoo;
import com.example.TODO.list.Service.Tools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class Cont {
    @Autowired
    public Tools tool;
    public Cont(Tools tool) {
        this.tool = tool;
    }
    @GetMapping("/main")
    public String find(Model m){
        List<Todoo> item = tool.findAll();
        m.addAttribute("saved", item);
        return "List";
    }
    @GetMapping("/add")
    public String add(Model m){
        Todoo ad = new Todoo();
        m.addAttribute("ad", ad);
        return "From";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute("ad") Todoo add){
        tool.save(add);
        return "redirect:/main";
    }
}