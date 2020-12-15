package com.demo.contact.domain;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import javax.persistence.*;

@Entity
public class ContactMovie {

    @EmbeddedId
    ContactMovieKey id;

    @ManyToOne
    @MapsId("contactId")
    @JoinColumn(name = "contact_id")
    @JsonBackReference
    Contact contact;

    @ManyToOne
    @MapsId("movieId")
    @JoinColumn(name = "movie_id")
    Movie movie;

    public int score;

    public String observations;

    public ContactMovieKey getId() {
        return id;
    }

    public void setId(ContactMovieKey id) {
        this.id = id;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }
}
