package com.example.SpringAuth.Controllers;

import com.example.SpringAuth.Model.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentCont {
        public List<Student> s = new ArrayList<>(List.of(
                new Student(1, "Haytam", 5),
                new Student(2, "Black", 20)
        ));

        @GetMapping("/students")
        public List<Student> getall(){
            return s;
        }
        @GetMapping("/csrf")
        public Object CsrtToken(HttpServletRequest servletRequest){
            return servletRequest.getAttribute("_ csrf");
        }
        @PostMapping("/students")
        public Student add(@RequestBody Student student){
            s.add(student);
            return student;
        }
}