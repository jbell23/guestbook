package com.joseph.guestbook.domain;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

@Entity
@Table(name = "GUEST_BOOK_ENTRY")
public class GuestBookEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty
    private String comment;

    @NotEmpty
    private String user;


}
