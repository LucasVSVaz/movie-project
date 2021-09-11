package br.com.lucas.movie.project.repository;

import br.com.lucas.movie.project.model.Movie;
import br.com.lucas.movie.project.model.MovieStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> findByStatus(MovieStatus status);
}
