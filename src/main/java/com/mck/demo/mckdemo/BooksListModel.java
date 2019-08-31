package com.mck.demo.mckdemo;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.IOException;
import java.util.Set;

@Named
public class BooksListModel {
    private static final String NO_RECORDS_MESSAGE = "No records";

    @Autowired
    @Getter
    private Set<Book> booksCache;

    public boolean booksEmpty() {
        return booksCache.isEmpty();
    }

    public boolean renderBooksList() {
        return !booksCache.isEmpty();
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
        //for hardcoded tests
    }

}
