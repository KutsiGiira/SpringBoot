package com.example.RESTCRUD.Dao;

import com.example.RESTCRUD.Entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MoviesRepo extends JpaRepository<Movie, Integer> {
}