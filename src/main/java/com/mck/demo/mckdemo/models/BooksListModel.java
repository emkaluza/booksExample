package com.mck.demo.mckdemo.models;

import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.IOException;
import java.util.Set;

@Named
public class BooksListModel {
    private static final Logger LOGGER = LoggerFactory.getLogger(BooksListModel.class);
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
        LOGGER.debug("addBook()");
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        try {
            externalContext.redirect("/addBook.xhtml");
        } catch (IOException e) {
            LOGGER.error("Problem redirecting /addBook.xhtml", e);
        }
    }

    @PostConstruct
    public void init() {
        //for hardcoded tests
    }

}
