package main.java.ro.ubb.bookstore.util;

import main.java.ro.ubb.bookstore.domain.BaseEntity;

/**
 * Created by Bianca on 20/03/2016.
 */

public class XmlWriter<ID, T extends BaseEntity<ID>> {

    private String fileName;

    public XmlWriter(String fileName) {
        this.fileName = fileName;
    }

    public void save(T entity) {
        //TODO implement writer
    }

}