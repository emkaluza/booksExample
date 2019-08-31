package com.mck.demo.mckdemo;

import com.mck.demo.mckdemo.bookscache.BooksCache;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    //Not really ideal solution, but will act like simplest data store available
    private final BooksCache booksCache = new BooksCache();

    @Bean
    public BooksCache booksCache() {
        return booksCache;
    }
}
