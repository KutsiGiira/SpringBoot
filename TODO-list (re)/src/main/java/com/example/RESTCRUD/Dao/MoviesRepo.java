package com.example.RESTCRUD.Dao;

import com.example.RESTCRUD.Entity.movies;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoviesRepo extends JpaRepository<movies, Integer> {
}
