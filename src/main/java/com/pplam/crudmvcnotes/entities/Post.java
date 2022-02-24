package com.pplam.crudmvcnotes.entities;

import javax.persistence.*;

@Entity
@Table(name = "Posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String title, body;

    public Post() {
        super();
    }

    public Post(String title, String body) {
        this.setTitle(title);
        this.setBody(body);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
