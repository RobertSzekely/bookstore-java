package main.java.ro.ubb.bookstore.domain;

/**
 * Created by robertszekely on 06/03/16.
 */
public class BaseEntity<ID> {
    private ID id;

    public ID getId() {
        return id;
    }
    public void setId(ID id) {
        this.id = id;
    }
    public String toString() {
        return "BaseEntity{" + "id=" + id + "}";
    }
}
