package com.joseph.beer.domain;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "entries")
public class BeerEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "entry_id")
    private Integer id;

    @NotEmpty
    @Size(min=3, max=40)
    @Column (name = "beer")
    private String beer;

    @NotEmpty
    @Size(min=3, max=40)
    @Column (name = "comment")
    private String comment;

    @NotEmpty
    @Size(min = 3, max = 30)
    @Column (name = "country")
    private String country;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Column (name = "percent", nullable = false)
    @NotNull(message = "Alcohol Percent Cannot Be Empty")
    @Range(max = 100)
    private Integer percent;

    @Column (name = "time")
    private String time;

    public Integer getPercent() {
        return percent;
    }

    public void setPercent(Integer percent) {
        this.percent = percent;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

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

    public String getBeer() {
        return beer;
    }

    public void setBeer(String beer) {
        this.beer = beer;
    }
}
