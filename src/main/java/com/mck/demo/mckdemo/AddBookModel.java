package com.mck.demo.mckdemo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.IOException;

@Named
public class AddBookModel {

    @Getter @Setter private String author;
    @Getter @Setter private String title;
    @Getter @Setter private String isbn;

    @Autowired


    public void addBook() {
        if (author.matches("(^[A].*)|(.*\\s+[A]{1}.*)")) { //find first letter A -OR- after whitespace letter A
            ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
            try {
                externalContext.redirect("/index.xhtml");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return;
        }

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Validation error, author name or surname must start from letter 'A'"));
    }
}
