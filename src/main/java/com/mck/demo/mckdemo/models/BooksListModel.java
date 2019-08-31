package com.mck.demo.mckdemo.models;

import com.mck.demo.mckdemo.bookscache.BooksCache;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.IOException;

@Named
public class BooksListModel {
    private static final Logger LOGGER = LoggerFactory.getLogger(BooksListModel.class);
    private static final String NO_RECORDS_MESSAGE = "No records";

    @Autowired
    @Getter
    private BooksCache booksCache;

    public boolean booksEmpty() {
        return booksCache.getBooksCache().isEmpty();
    }

    public boolean renderBooksList() {
        return !booksCache.getBooksCache().isEmpty();
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
