package br.com.lucas.movie.project.controller;

import br.com.lucas.movie.project.dto.MovieDto;
import br.com.lucas.movie.project.model.Movie;
import br.com.lucas.movie.project.model.MovieStatus;
import br.com.lucas.movie.project.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    private MovieRepository repository;

    @GetMapping("formulario")
    public String formulario() {
        return "movies/formulario";
    }

    @PostMapping("new")
    public String novo(@Valid MovieDto movieDto, BindingResult result) {
        if (result.hasErrors()) {
            return "movies/formulario";
        }
        Movie movie = movieDto.toMovie();
        movie.setStatus(MovieStatus.AGUARDANDO);
        repository.save(movie);
        return "redirect:/home";
    }

}
