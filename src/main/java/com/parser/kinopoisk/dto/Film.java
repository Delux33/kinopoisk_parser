package com.parser.kinopoisk.dto;

import javax.persistence.*;

@Entity
@Table(name = "TOP_FILMS")
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int position;
    private String name;
    private String rating;
    private int releaseYear;
    private String numberOfVotes;
    private String date;

    public Film() {
    }

    public Film(int position, String name, String rating, int releaseYear, String numberOfVotes, String date) {
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

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
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

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
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
