package com.example.RESTCRUD.service;

import com.example.RESTCRUD.Dao.movieImp;
import com.example.RESTCRUD.Entity.movies;
import com.example.RESTCRUD.restCont.MovieController;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ServiceDao implements ServiceInt{
    private movieImp movi;
@Autowired
    public ServiceDao(movieImp movi) { //CAUTION
        this.movi = movi;
    }

    @Override
    public List<movies> show() {
        return movi.show();
    }

    @Override
    public movies findById(int id) {
        return movi.findById(id);
    }
@Transactional
    @Override
    public void delete(int id) {
        movi.delete(id);
    }
@Transactional
    @Override
    public movies save(movies mov) {
        return movi.save(mov);
    }
}
