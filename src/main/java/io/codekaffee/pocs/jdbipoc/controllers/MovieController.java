package io.codekaffee.pocs.jdbipoc.controllers;

import io.codekaffee.pocs.jdbipoc.domain.models.Movie;
import io.codekaffee.pocs.jdbipoc.usecases.ListMoviesCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {


    private final ListMoviesCase listMoviesCase;

    public MovieController(ListMoviesCase listMoviesCase) {
        this.listMoviesCase = listMoviesCase;
    }

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies() {
        var movies =  listMoviesCase.listMovies();
        return  ResponseEntity.ok(movies);
    }


    @GetMapping("{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable("id") Long id) {
        return ResponseEntity.ok().build();
    }


}
