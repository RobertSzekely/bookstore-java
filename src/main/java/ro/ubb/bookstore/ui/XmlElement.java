package main.java.ro.ubb.bookstore.ui;

/**
 * Created by robertszekely on 25/03/16.
 */
public enum XmlElement {
    FIELD("field"), NAME("name"), TYPE("type"), VALUE("value"), ENTITY("entity"), CLASS("class");

    private final String value;

    XmlElement(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
