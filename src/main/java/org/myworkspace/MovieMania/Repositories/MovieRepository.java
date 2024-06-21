package org.myworkspace.MovieMania.Repositories;

import org.myworkspace.MovieMania.Entities.Movie;
import org.myworkspace.MovieMania.Entities.enums.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    boolean existsByTitle(String title);
    public Movie findByTitle(String title);
    public List<Movie> findByGenre(Genre genre);
}
