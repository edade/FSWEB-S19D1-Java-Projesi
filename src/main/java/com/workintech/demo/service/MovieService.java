package com.workintech.demo.service;



import com.workintech.demo.entity.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> findAll();
    Movie findById(Long id);

    Movie save(Movie movie);

    void delete(Movie movie);
}