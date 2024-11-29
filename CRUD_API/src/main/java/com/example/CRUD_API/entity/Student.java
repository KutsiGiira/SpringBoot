package com.example.CRUD_API.entity;

import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "students")
public class Student {
    public Student(String name) {
        this.name = name;
    }
    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public Student() {
    }

    @Id
@GeneratedValue(strategy= GenerationType.IDENTITY)
@Column(name = "id")
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @Column(name = "name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}