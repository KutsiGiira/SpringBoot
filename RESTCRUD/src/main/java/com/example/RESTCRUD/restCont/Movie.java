package com.example.RESTCRUD.restCont;

import com.example.RESTCRUD.Dao.movieImp;
import com.example.RESTCRUD.Entity.movies;
import com.example.RESTCRUD.service.ServiceDao;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping
public class Movie {
    private ServiceDao service;

    public Movie(ServiceDao movi) {
        service = movi;
    }

@GetMapping("/list")
    public List<movies> showList(){
        return service.show();
    }
}