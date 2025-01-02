package com.example.Json2db.Model;

import com.example.Json2db.entity.Quote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuoteJPA extends JpaRepository<Quote, Integer> {
    List<Quote> findAll();
}
