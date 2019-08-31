package com.mck.demo.mckdemo;

import com.mck.demo.mckdemo.models.Book;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashSet;
import java.util.Set;

@Configuration
public class AppConfig {

    //Not really ideal solution, but will act like simplest data store available
    private final Set<Book> booksCache = new HashSet<>();

    @Bean
    public Set<Book> booksCache() {
        return booksCache;
    }
}
