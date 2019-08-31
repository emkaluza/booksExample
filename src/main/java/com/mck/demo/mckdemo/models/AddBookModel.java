package com.mck.demo.mckdemo.models;

import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.IOException;
import java.util.Set;

@Named
public class AddBookModel {
    private static final Logger LOGGER = LoggerFactory.getLogger(AddBookModel.class);

    @Getter @Setter private String author;
    @Getter @Setter private String title;
    @Getter @Setter private String isbn;

    @Autowired
    private Set<Book> booksCache;

    public void addBook() {
        LOGGER.debug(String.format("addBook() - %s | %s | %s", author,title,isbn));
        if (author.matches("(^[A].*)|(.*\\s+[A]{1}.*)")) { //find first letter A -OR- after whitespace letter A
            ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
            try {
                booksCache.add(new Book(author, title, isbn));
                externalContext.redirect("/index.xhtml");
            } catch (IOException e) {
                LOGGER.debug("Redirect problem - /index.xhtml", e);
            }
            cleanData();
            return;
        }
        LOGGER.debug("Validation failed");
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Validation error, author name or surname must start from letter 'A'"));
    }

    private void cleanData() {
        LOGGER.debug("cleanData()");
        author = "";
        title = "";
        isbn = "";
    }
}
