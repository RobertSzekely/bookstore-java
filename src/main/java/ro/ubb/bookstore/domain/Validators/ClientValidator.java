package main.java.ro.ubb.bookstore.domain.Validators;

import main.java.ro.ubb.bookstore.domain.Client;

/**
 * Created by robertszekely on 06/03/16.
 */
public class ClientValidator implements Validator<Client> {
    @Override
    public void validate(Client entity) throws ValidatorException {
        if (entity.getFirstName() == null)
            throw new ValidatorException("First name is empty.");
        if (entity.getLastName() == null)
            throw new ValidatorException("Last name is empty.");
        if (entity.getEmail() == null)
            throw new ValidatorException("Email is empty.");
        if (entity.getTelephone() == null)
            throw new ValidatorException("Telephone is empty.");
    }
}
