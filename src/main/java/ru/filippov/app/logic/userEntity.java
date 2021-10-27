package ru.filippov.app.logic;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class userEntity {
    @Id
    String id;
    String firstName;

    public userEntity(String id, String firstName) {
        this.id = id;
        this.firstName = firstName;
    }

    public userEntity() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
