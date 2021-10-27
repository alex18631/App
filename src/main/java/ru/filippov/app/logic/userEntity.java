package ru.filippov.app.logic;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class userEntity {
    @Id
    String id;
    String name;

    public userEntity(String id, String firstName) {
        this.id = id;
        this.name = firstName;
    }

    public userEntity() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
