package org.myworkspace.MovieMania.Services;

import lombok.extern.slf4j.Slf4j;
import org.myworkspace.MovieMania.Entities.Movie;
import org.myworkspace.MovieMania.Repositories.MovieRepository;
import org.myworkspace.MovieMania.Resources.MovieResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.persistence.EntityNotFoundException;
import org.myworkspace.MovieMania.Utils.NotFoundException;

import java.util.Objects;
import java.util.Optional;

@Slf4j
@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public MovieResource addMovie(MovieResource movieRequest) {
        Movie movie = Movie.toEntity(movieRequest);
        if (movieRepository.existsByTitle(movieRequest.getTitle())) {
            return Movie.toResource(movie);
        }
        movie = movieRepository.save(movie);
        log.info("Added New Movie"+ movie.toString());
        return Movie.toResource(movie);
    }

    public MovieResource getMovie(long id) {
        Optional<Movie> movie = movieRepository.findById(id);
        if (movie.isEmpty()) {
            throw new EntityNotFoundException("Movie not found:" + id);
        }
        return Movie.toResource(movie.get());
    }

    public MovieResource getMovie(String title) {
        Movie movie = movieRepository.findByTitle(title);
        if (Objects.isNull(movie)) {
            throw new NotFoundException("Movie not found:" + title);
        }
        return Movie.toResource(movie);
    }

}
