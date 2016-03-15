package main.java.ro.ubb.bookstore.domain.Validators;

import main.java.ro.ubb.bookstore.domain.BookClient;

/**
 * Created by Bianca on 13/03/2016.
 */
public class BookClientValidator implements Validator<BookClient>  {

    @Override
    public void validate(BookClient entity) throws ValidatorException {
        if (entity.getBook() == null)
            throw new ValidatorException("Book is empty.");
        if (entity.getClient() == null)
            throw new ValidatorException("Client is empty.");
    }
}
