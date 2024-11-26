package com.example.LinkDB.doa;

import com.example.LinkDB.entity.Anime;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AnimeImp implements AnimeDao{
    private EntityManager entityManager;
@Autowired
    public AnimeImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Anime anime) {// Log before saving
        entityManager.persist(anime);
    }
    @Override
    public Anime findById(Integer id) {
        return entityManager.find(Anime.class , id);
    }

    @Override
    public List<Anime> findAll() {
        TypedQuery<Anime> query = entityManager.createQuery("FROM Anime", Anime.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void update(Anime name) {
         entityManager.merge(name);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Anime anime = entityManager.find(Anime.class, id);
        entityManager.remove(anime);
    }
}