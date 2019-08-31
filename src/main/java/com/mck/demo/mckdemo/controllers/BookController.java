package com.mck.demo.mckdemo.controllers;

import com.mck.demo.mckdemo.bookscache.BookValidationException;
import com.mck.demo.mckdemo.bookscache.BooksCache;
import com.mck.demo.mckdemo.models.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class BookController {
    private static final Logger LOGGER = LoggerFactory.getLogger(BookController.class);

    @Autowired
    private BooksCache booksCache;

    @RequestMapping(value="/addBook")
    public ResponseEntity<String> addBook(@RequestParam(value = "author") final String author, @RequestParam(value = "title") final String title, @RequestParam(value = "isbn") final String isbn) {
        try {
            booksCache.addBook(new Book(author, title, isbn));
        } catch (BookValidationException e) {
            LOGGER.error("/addBook validation failed", e);
            return ResponseEntity.badRequest()
                    .body(e.getMessage());
        }
        return ResponseEntity.ok()
                .body("book added");
    }

    @RequestMapping("/getAllBooks")
    public Set<Book> getAllBooks() {
        return booksCache.getBooksCache();
    }

}
