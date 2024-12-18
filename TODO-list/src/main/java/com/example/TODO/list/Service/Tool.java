package com.example.TODO.list.Service;

import com.example.TODO.list.Controller.Cont;
import com.example.TODO.list.Model.Todoo;

import java.util.List;

public interface Tool {
    List<Todoo>findAll();
    Todoo save(Todoo Ntask);
}
