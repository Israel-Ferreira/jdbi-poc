package io.codekaffee.pocs.jdbipoc.usecases;


import io.codekaffee.pocs.jdbipoc.domain.models.Movie;
import io.codekaffee.pocs.jdbipoc.domain.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ListMoviesCase {

    private final MovieRepository movieRepository;

    public List<Movie> listMovies() {
        return movieRepository.listAllMovies();
    }

}
