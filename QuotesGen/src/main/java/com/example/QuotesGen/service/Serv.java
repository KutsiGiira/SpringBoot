package com.example.QuotesGen.service;

import com.example.QuotesGen.model.Mod;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.List;

@Service
public class Serv {
    public Mod readJsonFile() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        ClassPathResource resource = new ClassPathResource("static/base.json");
        InputStream jsonInput = resource.getInputStream();
        return objectMapper.readValue(jsonInput, Mod.class);
    }
}
