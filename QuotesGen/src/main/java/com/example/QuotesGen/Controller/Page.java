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
import java.util.Map;

@Controller
public class Page {
    @Autowired
    public Serv serv;
    public Page(Serv serv){
        this.serv = serv;
    }
//    @GetMapping("/main")
//    public String mainPage(Model m) throws IOException {
//        try {
//            Mod quote = serv.readJsonFile();
//            m.addAttribute("quote", quote);
//        } catch (IOException e) {
//            e.printStackTrace();
//            m.addAttribute("error", "Unable to load quotes at this time.");
//        }
//        return "main";
//    }
    @GetMapping("/json")
    public String viewJson(Model model) {
        List<Map<String, Object>> jsonData = serv.getJsonData();
        model.addAttribute("quote", jsonData);
        return "json-view";
    }
}
