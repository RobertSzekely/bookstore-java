package main.java.ro.ubb.bookstore.util;

/**
 * Created by Bianca on 20/03/2016.
 */

enum XmlElement {
    FIELD("field"), NAME("name"), TYPE("type"), VALUE("value"), ENTITY("entity"), CLASS("class");

    private final String value;

    XmlElement(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
