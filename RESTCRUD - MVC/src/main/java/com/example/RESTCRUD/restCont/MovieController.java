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
    @GetMapping("/add")
    public String add(Model m){
        movies add = new movies();
        m.addAttribute("add", add);
        return "addForm";
    }
    @PostMapping("/saved")
    public String save(@ModelAttribute("add") movies theMovie){
        serviceDao.save(theMovie);
        return "redirect:/list";
    }
    @GetMapping("/update")
    public String update(@RequestParam("movieId")int idd, Model m){
        movies mm = serviceDao.findById(idd);
        m.addAttribute("up", mm);
        return"redirect:/add";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam("movieId")int id){
        serviceDao.delete(id);
        return "redirect:/list";
    }
}