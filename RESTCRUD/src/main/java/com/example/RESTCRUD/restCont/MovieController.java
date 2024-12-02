package com.example.RESTCRUD.restCont;

import com.example.RESTCRUD.Entity.movies;
import com.example.RESTCRUD.service.ServiceDao;
import com.example.RESTCRUD.service.ServiceInt;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class MovieController {
    private ServiceInt service;

    public MovieController(ServiceInt movi) {
        service = movi;
    }

@GetMapping("/list")
    public List<movies> showList(){
        return service.show();
    }
    @GetMapping("/list/{iid}")
    public movies get(@PathVariable int iid){
        movies m = service.findById(iid);
            if(m == null){
                throw new RuntimeException("Not found "+ iid);
            }
            return m;
    }
    @PostMapping("/list")
    public movies add(@RequestBody movies m){
        m.setId(0);
        movies n = service.save(m);
        return n;
    }
}