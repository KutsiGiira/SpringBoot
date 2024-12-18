package com.example.RESTCRUD.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "movies")
public class movies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;

    public movies() {
    }

    public movies(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "movies{" + "id=" + id + ", name='" + name + '\'' +  '}';
    }
}
