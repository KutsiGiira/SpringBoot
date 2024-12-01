package com.example.RESTCRUD.Dao;

import com.example.RESTCRUD.Entity.movies;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Repository
public class movieImp implements Int{
    private EntityManager entityManager;
@Autowired
    public EntityManager getEntityManager(EntityManager manager) {
        entityManager = manager;
        return entityManager;
    }
    @Override
    public List<movies> show() {
        TypedQuery<movies> query = entityManager.createQuery("FROM movies", movies.class);
        List<movies> movie = query.getResultList();
        return movie;
    }
}
