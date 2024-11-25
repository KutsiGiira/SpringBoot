package com.example.LinkDB.doa;

import com.example.LinkDB.entity.Anime;

public interface AnimeDao {
    void save(Anime name);
    Anime findById(Integer id);
}
