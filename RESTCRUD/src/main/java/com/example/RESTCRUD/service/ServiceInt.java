package com.example.RESTCRUD.service;

import com.example.RESTCRUD.Entity.movies;
import com.example.RESTCRUD.restCont.MovieController;

import java.util.List;

public interface ServiceInt {
    List<movies> show();
    movies findById(int id);
    void delete(int id);
    movies save(movies mov);
}