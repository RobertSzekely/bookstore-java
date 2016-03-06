package main.java.ro.ubb.bookstore.domain.Validators;

import javax.xml.bind.ValidationException;

/**
 * Created by robertszekely on 06/03/16.
 */
public class ValidatorException extends Exception {

    public ValidatorException(String message) {
        super(message);
    }
}
