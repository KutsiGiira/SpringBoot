package com.example.RESTCRUD.Dao;


import com.example.RESTCRUD.Entity.movies;
import com.example.RESTCRUD.restCont.MovieController;

import java.util.List;

public interface Int {
        List<movies> show();
        movies findById(int id);
        void delete(int id);
        movies save(movies mov);
}
