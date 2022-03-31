package com.parser.kinopoisk.dto;

import javax.persistence.*;

@Entity
@Table(name = "TOP_FILMS")
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String position;
    private String name;
    private String rating;
    private String releaseYear;
    private String numberOfVotes;
    private String date;

    public Film() {
    }

    public Film(String position, String name, String rating, String releaseYear, String numberOfVotes, String date) {
        this.position = position;
        this.name = name;
        this.rating = rating;
        this.releaseYear = releaseYear;
        this.numberOfVotes = numberOfVotes;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getNumberOfVotes() {
        return numberOfVotes;
    }

    public void setNumberOfVotes(String numberOfVotes) {
        this.numberOfVotes = numberOfVotes;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
