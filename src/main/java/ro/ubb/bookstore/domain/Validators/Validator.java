package main.java.ro.ubb.bookstore.domain.Validators;


/**
 * Created by robertszekely on 06/03/16.
 */
public interface Validator<T> {
    void validate(T entity) throws ValidatorException;
}
