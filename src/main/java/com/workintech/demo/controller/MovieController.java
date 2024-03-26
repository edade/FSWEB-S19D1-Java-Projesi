package com.workintech.demo.controller;

import com.workintech.demo.entity.Movie;
import com.workintech.demo.service.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/movies")
public class MovieController {
    private final MovieService movieService;


    @GetMapping
    public List<Movie> getAllMovies() {
        return movieService.findAll();
    }


    @GetMapping("/{id}")
    public Movie getMovieById(@PathVariable Long id) {
        return movieService.findById(id);
    }


    @PostMapping
    public Movie addMovie(@RequestBody Movie movie) {
        return movieService.save(movie);
    }


    @PutMapping("/{id}")
    public Movie updateMovie(@PathVariable Long id, @RequestBody Movie movie) {
        Movie existingMovie = movieService.findById(id);
        // Update existing movie properties with new data
        existingMovie.setName(movie.getName());
        existingMovie.setDirectorName(movie.getDirectorName());
        existingMovie.setRating(movie.getRating());
        existingMovie.setReleaseDate(movie.getReleaseDate());
        existingMovie.setActors(movie.getActors());
        return movieService.save(existingMovie);
    }

    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable Long id) {
        Movie movieToDelete = movieService.findById(id);
        movieService.delete(movieToDelete);
    }
}
