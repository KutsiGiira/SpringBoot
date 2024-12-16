package com.example.TODO.list.Controller;

import com.example.TODO.list.Model.Todoo;
import com.example.TODO.list.Service.Tools;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class Cont {
    public Tools tool;
    public String req;
    public Cont(Tools tool) {
        this.tool = tool;
    }
    @GetMapping("/from")
    public String list(){
        return "From";
    }
    @GetMapping("/list")
    public String todayTask(Model m){
        List<Todoo> msg = tool.show();
        m.addAttribute("temp", msg);
        m.addAttribute("t", req);
        return "List";
    }
}