package com.example.rest.restCnt;

import com.example.rest.entity.Students;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RequestMapping
@RestController
public class RestC {
    @GetMapping("/h")
    public String Hello(){
        return "Hello World";
    }
}