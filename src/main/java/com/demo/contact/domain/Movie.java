package com.demo.contact.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class Movie {

    @Id
    @GeneratedValue
    private Long movieId;
    private String movie;

    public Movie() {
    }

    public Movie(Long movieId, String movie) {
        this.movieId = movieId;
        this.movie = movie;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }
}
