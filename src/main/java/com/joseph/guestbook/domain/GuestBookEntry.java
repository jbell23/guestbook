package com.joseph.guestbook.domain;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

@Entity
@Table(name = "entries")
public class GuestBookEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "entry_id")
    private Integer id;

    @NotEmpty
    @Column (name = "comment")
    private String comment;

    @NotEmpty
    @Column (name = "user")
    private String user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
