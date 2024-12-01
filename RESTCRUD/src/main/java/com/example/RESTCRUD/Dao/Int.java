package com.example.RESTCRUD.Dao;


import com.example.RESTCRUD.Entity.movies;
import com.example.RESTCRUD.restCont.Movie;

import java.util.List;

public interface Int {
        List<movies> show();
        Movie findById(int id);
        void delete(int id);
        Movie save(Movie mov);
}
