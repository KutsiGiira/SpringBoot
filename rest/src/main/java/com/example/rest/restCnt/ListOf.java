package com.example.rest.restCnt;

import com.example.rest.entity.Students;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping
public class ListOf {
    private List<Students> l;
    @PostConstruct
    public void  Data(){
        l = new ArrayList<>();
        l.add(new Students("Black", "Kutsi"));
        l.add(new Students("KutsiGria", "Blake"));
    }
    @GetMapping("/list")
    public List<Students> List(){
        return l;
    }
    @GetMapping("/list/{id}")
    public Students getName(@PathVariable int id){
        return l.get(id);
    }

}
