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
    @GetMapping("/from")
    public String list(Model m){
        List<Todoo> todo = tool.findAll();
        m.addAttribute("todo", todo);
        return "From";
    }
    @PostMapping("/add")
    public String addTask(Model m) {
        Todoo tod = new Todoo();
        m.addAttribute("added", tod);
        return "List";
    }

    @GetMapping("/main")
    public String find(Model m){
        List<Todoo> item = tool.findAll();
        m.addAttribute("saved", item);
        return "List";
    }
}