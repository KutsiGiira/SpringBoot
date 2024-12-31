package com.example.QuotesGen.Controller;

import com.example.QuotesGen.model.Mod;
import com.example.QuotesGen.service.Serv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class Page {
    @Autowired
    public Serv serv;
    public Page(Serv serv){
        this.serv = serv;
    }
    @GetMapping("/main")
    public String mainPage(Model m) throws IOException {
        try {
            Mod quote = serv.readJsonFile();
            m.addAttribute("quote", quote);
        } catch (IOException e) {
            e.printStackTrace();
            m.addAttribute("error", "Unable to load quotes at this time.");
        }
        return "main";
    }
    @GetMapping("/json")
    @ResponseBody
    public List<Mod> Json(Model m){
        List<Mod> json = new ArrayList<Mod>();

        m.addAttribute("quote", json);
        return json;
    }
}
