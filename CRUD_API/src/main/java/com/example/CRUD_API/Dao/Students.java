package com.example.CRUD_API.Dao;

import com.example.CRUD_API.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class Students implements Std{
    private EntityManager entityManager;
    @Autowired
    public Students(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @Override
    @Transactional
    public void create(Student name) {
        entityManager.persist(name);
    }
    @Override
    @Transactional
    public void delete(Integer id) {
        Student name = entityManager.find(Student.class, id);
        entityManager.remove(name);
    }

    @Override
    @Transactional
    public void update(Student s) {
        entityManager.merge(s);
    }

    @Override
    public Student findbyid(int id) {
        return entityManager.find(Student.class, id);
    }
}