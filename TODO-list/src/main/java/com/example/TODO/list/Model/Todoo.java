package com.example.TODO.list.Model;
import jakarta.persistence.*;
@Entity
@Table(name="list")
public class Todoo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="Task")
    private String task;
    @Column(name="done")
    private boolean done = false;

    public Todoo() {
    }

    public Todoo(String task) {
        this.task = task;
    }

    public Todoo(boolean done, String task) {
        this.done = done;
        this.task = task;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
    @Override
    public String toString() {
        return "Todoo{" +
                "id=" + id +
                ", task='" + task + '\'' +
                ", done=" + done +
                '}';
    }
}
