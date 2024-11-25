package com.example.LinkDB.doa;

import com.example.LinkDB.entity.Anime;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AnimeImp implements AnimeDao{
    private EntityManager entityManager;
@Autowired
    public AnimeImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
//    public void save(Anime anime) {
//        entityManager.persist(anime);
//        System.out.println("Saved Anime ID: " + anime.getId());

    public void save(Anime anime) {// Log before saving
        entityManager.persist(anime);
    }


    @Override
    public Anime findById(Integer id) {
        return entityManager.find(Anime.class , id);
    }
}