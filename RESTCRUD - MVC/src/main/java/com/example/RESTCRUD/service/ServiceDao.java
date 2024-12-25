package com.example.RESTCRUD.service;

import com.example.RESTCRUD.Dao.MoviesRepo;
import com.example.RESTCRUD.Entity.movies;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceDao implements ServiceInt{
    private MoviesRepo movi;
@Autowired
    public ServiceDao(MoviesRepo movi) { //CAUTION
        this.movi = movi;
    }

    @Override
    public List<movies> show() {
        return movi.findAll();
    }

    @Override
    public movies findById(int id) {
        Optional<movies> r = movi.findById(id);
        movies m = null;
        if(r.isPresent()){
            m = r.get();
        }
        else{
            throw new RuntimeException("Did not be found");
        }
        return m;
    }
    @Override
    public void delete(int id) {
         movi.deleteById(id);
    }
    @Override
    public movies save(movies mov) {
        return movi.save(mov);
    }
}
