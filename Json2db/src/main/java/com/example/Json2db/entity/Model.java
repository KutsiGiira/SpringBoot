package com.example.Json2db.entity;


import jakarta.persistence.*;

import java.awt.geom.GeneralPath;

@Entity
@Table(name="quotetest")
public class Model {
    @Id
    @GeneratedValue(strategy =GenerationType.AUTO)
    private int id;
    @Column(name="Name")
    private String name;
    @Column(name="Author")
    private String author;

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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Model{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
