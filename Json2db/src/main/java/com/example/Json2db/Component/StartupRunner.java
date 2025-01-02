package com.example.Json2db.Component;
import com.example.Json2db.Model.QuoteJPA;
import com.example.Json2db.entity.Quote;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.List;

@Component
public class StartupRunner implements CommandLineRunner {

        @Autowired
        private QuoteJPA quoteJPA;

    @Override
    public void run(String... args) throws Exception {
        // Reading the JSON file from resources folder
        ObjectMapper objectMapper = new ObjectMapper();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("/data/base.json");

        if (inputStream != null) {
            // Deserialize JSON into a list of Quote objects
            List<Quote> quotes = objectMapper.readValue(inputStream, new TypeReference<List<Quote>>() {
            });

            // Save the quotes to the database
            quoteJPA.saveAll(quotes);
        }
    }
}

