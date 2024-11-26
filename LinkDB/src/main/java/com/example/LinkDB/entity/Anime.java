package com.example.LinkDB.entity;

import jakarta.persistence.*;

@Entity
@Table(name="anime")
public class Anime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private int id;
    @Column(name ="name")
    private String name;

    public Anime(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public Anime(String name) {
        this.name = name;
    }
    public Anime() {
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    @Override
    public String toString() {
        return "Anime{" + "id=" + id + ", name='" + name + '\'' + '}';
    }
}
