package com.example.RESTCRUD.service;

import com.example.RESTCRUD.Entity.movies;
import com.example.RESTCRUD.restCont.Movie;

import java.util.List;

public interface ServiceInt {
    List<movies> show();
    Movie findById(int id);
    void delete(int id);
    Movie save(Movie mov);
}
