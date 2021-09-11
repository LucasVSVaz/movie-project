package br.com.lucas.movie.project.dto;

import br.com.lucas.movie.project.model.Movie;
import br.com.lucas.movie.project.model.MovieGenre;
import br.com.lucas.movie.project.model.MovieStatus;

public class MovieDto {
    private String name;
    private String description;
    private String urlImage;
    private MovieGenre genre;
    private MovieStatus status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public MovieGenre getGenre() {
        return genre;
    }

    public void setGenre(MovieGenre genre) {
        this.genre = genre;
    }

    public MovieStatus getStatus() {
        return status;
    }

    public void setStatus(MovieStatus status) {
        this.status = status;
    }

    public Movie toMovie() {
        Movie movie = new Movie();
        movie.setName(this.name);
        movie.setStatus(this.status);
        movie.setDescription(this.description);
        movie.setUrlImage(this.urlImage);
        movie.setGenre(this.genre);
        return movie;
    }
}
