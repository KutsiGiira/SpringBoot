package com.example.RESTCRUD.restCont;

import com.example.RESTCRUD.Dao.movieImp;
import com.example.RESTCRUD.Entity.movies;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping
public class Movie {
    private movieImp movi;

    public Movie(movieImp movi) {
        this.movi = movi;
    }

@GetMapping("/list")
    public List<movies> showList(){
        return movi.show();
    }
}