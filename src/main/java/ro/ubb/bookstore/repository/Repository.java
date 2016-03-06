package main.java.ro.ubb.bookstore.repository;

import main.java.ro.ubb.bookstore.domain.BaseEntity;
import main.java.ro.ubb.bookstore.domain.Book;
import main.java.ro.ubb.bookstore.domain.Client;
import main.java.ro.ubb.bookstore.domain.Validators.ValidatorException;

import javax.xml.bind.ValidationException;
import java.util.List;
import java.util.Optional;

/**
 * Created by robertszekely on 27/02/16.
 */
public interface Repository<ID, T extends BaseEntity<ID>> {

    /**
     * Find the entity with the given {@code id}
     * @return
     */

    Optional<T> findOne(ID id);

    Iterable<T> findAll();

    Optional<T> save(T entity) throws ValidatorException;

    Optional<T> delete(ID id);

    Optional<T> update(T entity) throws ValidatorException;

}
