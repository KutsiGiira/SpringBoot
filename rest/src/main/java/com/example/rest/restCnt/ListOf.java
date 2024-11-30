package com.example.rest.restCnt;

import com.example.rest.entity.Students;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping
public class ListOf {
    @GetMapping("/list")
    public List<Students> List(){
        List<Students> l = new ArrayList<>();
        l.add(new Students("Black", "Kutsi"));
        l.add(new Students("KutsiGria", "Blake"));
        return l;
    }
}
