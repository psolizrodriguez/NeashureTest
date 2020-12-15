package com.demo.contact.repository;

import com.demo.contact.domain.Contact;
import com.demo.contact.domain.Movie;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MovieRepository extends CrudRepository<Movie, Long> {

    public List<Movie> findAll();
}
