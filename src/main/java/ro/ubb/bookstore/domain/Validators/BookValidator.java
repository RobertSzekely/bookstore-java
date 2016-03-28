package main.java.ro.ubb.bookstore.domain.Validators;

import main.java.ro.ubb.bookstore.domain.Book;

/**
 * Created by robertszekely on 06/03/16.
 */
public class BookValidator implements Validator<Long, Book> {

    @Override
    public void validate(Book entity) throws ValidatorException{
        if (entity.getTitle() == null)
            throw new ValidatorException("Title is empty.");
        if (entity.getAuthor() == null)
            throw new ValidatorException("Author is empty.");
        if (entity.getCategory() == null)
            throw new ValidatorException("Category is empty.");
        if (entity.getPrice() < 0)
            throw new ValidatorException("Price can not be negative.");
    }
}
