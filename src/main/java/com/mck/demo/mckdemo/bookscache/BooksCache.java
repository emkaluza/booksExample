package com.mck.demo.mckdemo.bookscache;

import com.mck.demo.mckdemo.models.Book;
import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

public class BooksCache {
    //Not really ideal solution, but will act like simplest data store available
    @Getter private final Set<Book> booksCache = new HashSet<>();

    public void addBook(final Book newBook) throws BookValidationException{
        validate(newBook);
        booksCache.add(newBook);
    }

    private void validate(final Book newBook) throws BookValidationException{
        if (!newBook.getAuthor().matches("(^[A].*)|(.*\\s+[A]{1}.*)")) { //find first letter A -OR- after whitespace letter A
            throw new BookValidationException("Validation error, author name or surname must start from letter 'A'");
        }
    }
}
