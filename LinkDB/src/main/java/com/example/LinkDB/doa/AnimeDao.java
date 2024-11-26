package com.example.LinkDB.doa;

import com.example.LinkDB.entity.Anime;

import java.util.List;

public interface AnimeDao {
    void save(Anime name);
    Anime findById(Integer id);
    List<Anime> findAll();
    void update(Anime name);
    void delete(Integer id);

}
