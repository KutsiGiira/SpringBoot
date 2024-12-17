package com.example.TODO.list.Controller;

import com.example.TODO.list.Model.Todoo;
import com.example.TODO.list.Service.Tools;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class Cont {
    public Tools tool;
    public Cont(Tools tool) {
        this.tool = tool;
    }
    @GetMapping("/from")
    public String list(Model m){
        Todoo todo = new Todoo();
        m.addAttribute("todo", todo);
        return "From";
    }
    @GetMapping("/list")
    public String req(@RequestParam String task){
        return "List";
    }
}