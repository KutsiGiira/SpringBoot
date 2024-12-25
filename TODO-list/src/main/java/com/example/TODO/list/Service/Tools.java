package com.example.TODO.list.Service;

import com.example.TODO.list.Doa.repo;
import com.example.TODO.list.Model.Todoo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Tools implements Tool{
    private repo Lrepo;
    @Autowired
    public Tools(repo Lrepo) {
        this.Lrepo = Lrepo;
    }
    @Override
    public List<Todoo>findAll() {
        return Lrepo.findAll();
    }

    @Override
    public Todoo save(Todoo tool) {
        return Lrepo.save(tool);
    }
}