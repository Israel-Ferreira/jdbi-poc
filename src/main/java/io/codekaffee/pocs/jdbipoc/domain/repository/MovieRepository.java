package io.codekaffee.pocs.jdbipoc.domain.repository;

import io.codekaffee.pocs.jdbipoc.domain.models.Movie;
import lombok.RequiredArgsConstructor;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.core.mapper.reflect.FieldMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MovieRepository {


    private final Jdbi jdbiProvider;


    public List<Movie> listAllMovies() {

        String queryMovies =  "select id, title, launch_year, genre  from movies m";

        return jdbiProvider.withHandle(handle -> {
            handle.registerRowMapper(FieldMapper.factory(Movie.class));
            return handle.select(queryMovies).mapTo(Movie.class).list();
        });
    }


    public Movie getMovieById(Long id) {

        String queryGetMovieById =  "select id, title, launch_year,  genre  from movies  where id = :movie_id";

        return jdbiProvider.withHandle(handle -> {
            handle.registerRowMapper(FieldMapper.factory(Movie.class, "m"));
            return  handle.select(queryGetMovieById)
                    .bind("movie_id", id)
                    .mapTo(Movie.class)
                    .one();
        });
    }

}
