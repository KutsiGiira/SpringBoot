package com.example.TODO.list.Doa;

import com.example.TODO.list.Model.Todoo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface repo extends JpaRepository<Todoo, Integer> {
}