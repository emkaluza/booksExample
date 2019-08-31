package com.mck.demo.mckdemo;

import lombok.Getter;

import javax.annotation.PostConstruct;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@Named
public class BooksListModel {
    private static final String NO_RECORDS_MESSAGE = "No records";

    @Getter private final Set<Book> books = new HashSet<Book>();

    public void addBook(final String author, final String title, final String ISBN) {
        books.add(new Book(author, title, ISBN));
    }

    public boolean booksEmpty() {
        return books.isEmpty();
    }

    public boolean renderBooksList() {
        return !books.isEmpty();
    }

    public String getNoRecordsMessage() {
        return NO_RECORDS_MESSAGE;
    }

    public void addBook() {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        try {
            externalContext.redirect("/addBook.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @PostConstruct
    public void init() {
        addBook("test1","tesdt2","test3");
    }

}
