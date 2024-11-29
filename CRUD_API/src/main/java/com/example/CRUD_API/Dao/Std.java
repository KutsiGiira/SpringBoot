package com.example.CRUD_API.Dao;

import com.example.CRUD_API.entity.Student;


public interface Std {
    void create(Student name);
    void delete(Integer id);
    void update(Student s);

    Student findbyid(int id);
}