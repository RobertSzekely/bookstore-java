package main.java.ro.ubb.bookstore.repository;

import main.java.ro.ubb.bookstore.domain.BaseEntity;
import main.java.ro.ubb.bookstore.domain.Validators.Validator;
import main.java.ro.ubb.bookstore.domain.Validators.ValidatorException;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by robertszekely on 27/02/16.
 */
public class InMemoryRepository<ID, T extends BaseEntity<ID>> implements Repository<ID, T> {


    private Map<ID, T> entities;
    private Validator<T> validator;

    public InMemoryRepository(Validator<T> validator) {
        this.validator = validator;
        entities = new HashMap<>();
    }


    @Override
    public Optional<T> findOne(ID id) {
        if(id == null) {
            throw new IllegalArgumentException("id must not be null");
        }
        return Optional.ofNullable(entities.get(id));
    }

    @Override
    public Iterable<T> findAll() {
        Set<T> allEntities = entities.entrySet().stream().map(entry -> entry.getValue()).collect(Collectors.toSet());
        return allEntities;
    }

    @Override
    public Optional<T> save (T entity) throws ValidatorException {
        if(entity == null) {
            throw new IllegalArgumentException("id must not be null");
        }
        validator.validate(entity);

        return Optional.ofNullable(entities.putIfAbsent(entity.getId(), entity));
    }

    @Override
    public Optional<T> delete (ID id) {
        if (id ==  null) {
            throw new IllegalArgumentException("id must not be null");
        }
        return Optional.ofNullable(entities.remove(id));
    }

    @Override
    public Optional<T> update (T entity) throws ValidatorException {
        if(entity == null) {
            throw new IllegalArgumentException("id must not be null");
        }
        validator.validate(entity);
        if(entities.containsKey(entity.getId())) {
            entities.put(entity.getId(), entity);
            return Optional.empty();
        }
        return Optional.of(entity);
    }
}
