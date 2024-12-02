package com.example.RESTCRUD.Dao;

import com.example.RESTCRUD.Entity.movies;
import com.example.RESTCRUD.restCont.MovieController;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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

    @Override
    public movies findById(int id) {
    movies m = entityManager.find(movies.class, id);
        return m;
    }

    @Override
    public void delete(int id) {
        movies m = entityManager.find(movies.class, id);
        entityManager.remove(m);
    }

    @Override
    public movies save(movies mov) {
        movies o = entityManager.merge(mov);
        return o;
    }
}