package com.example.QuotesGen.model;

import java.util.List;

public class Mod {
    private String author;
    private String quote;

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Mod{" +
                "author='" + author + '\'' +
                ", quote='" + quote + '\'' +
                '}';
    }
}