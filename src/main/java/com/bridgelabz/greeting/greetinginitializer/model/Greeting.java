package com.bridgelabz.greeting.greetinginitializer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Greetings")
public class Greeting {

    @Id
    private long id;
    @Column(name = "message")
    private String message;

    public long getIncrementAndGet() {
        return id;
    }

    public void setIncrementAndGet(long id) {
        this.id = id;
    }

    public String getFormat() {
        return message;
    }

    public void setFormat(String message) {
        this.message = message;
    }
}
