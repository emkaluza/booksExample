package com.mck.demo.mckdemo.controllers;

import com.mck.demo.mckdemo.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class AddBookController {

    @Autowired
    private Set<Book> booksCache;

    @RequestMapping("/addBook")
    public void addBook(@RequestParam(value = "author") final String author, @RequestParam(value = "title") final String title, @RequestParam(value = "isbn") final String isbn) {
        booksCache.add(new Book(author, title, isbn));
    }

    @RequestMapping("/getAllBooks")
    public Set<Book> getAllBooks() {
        return booksCache;
    }

}
