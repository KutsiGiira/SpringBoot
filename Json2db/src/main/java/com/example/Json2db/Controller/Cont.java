package com.example.Json2db.Controller;

import com.example.Json2db.Service.Service;
import com.example.Json2db.entity.Quote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Cont {
    @Autowired
    private Service service;

    @GetMapping("/random")
    public ResponseEntity<Quote> getRandomQuote() {
        Quote quote = service.getRandomQuote();
        return ResponseEntity.ok(quote);
    }
}
