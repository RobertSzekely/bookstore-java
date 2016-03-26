package main.java.ro.ubb.bookstore.domain.Validators;


import main.java.ro.ubb.bookstore.domain.BaseEntity;

/**
 * Created by robertszekely on 06/03/16.
 */
public interface Validator<T> {
    void validate(T entity) throws ValidatorException;
}
