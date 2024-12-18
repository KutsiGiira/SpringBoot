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
        Todoo todo = new Todoo();
        m.addAttribute("todo", todo);
        return "From";
    }
    @PostMapping("/add")
    public String addTask(@ModelAttribute Todoo todo) {
        tool.save(todo); // Save the task to the database
        return "List"; // Redirect to the form page after saving
    }

    @GetMapping("/db")
    public String find(Model m){
        List<Todoo> item = tool.findAll();
        m.addAttribute("saved", item);
        return "List";
    }
}