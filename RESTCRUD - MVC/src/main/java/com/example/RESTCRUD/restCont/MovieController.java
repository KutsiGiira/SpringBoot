package com.example.RESTCRUD.restCont;

import ch.qos.logback.core.joran.event.SaxEventRecorder;
import com.example.RESTCRUD.Entity.movies;
import com.example.RESTCRUD.service.ServiceDao;
import com.example.RESTCRUD.service.ServiceInt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping
public class MovieController {
    public ServiceDao serviceDao;
    public MovieController(ServiceDao service){
        serviceDao = service;
    }
    @GetMapping("/list")
    public String ListOf(Model m){
        List<movies> theMovie = serviceDao.show();
        m.addAttribute("movies", theMovie);
        return "ViewList";
    }
}