package com.example.Json2db.Service;

import com.example.Json2db.Model.QuoteJPA;
import com.example.Json2db.entity.Quote;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;
@org.springframework.stereotype.Service
public class Service {
    @Autowired
    private QuoteJPA quoteJPA;

    public Quote getRandomQuote() {
        List<Quote> quotes = quoteJPA.findAll();
        Random rand = new Random();
        return quotes.get(rand.nextInt(quotes.size()));
    }
}
