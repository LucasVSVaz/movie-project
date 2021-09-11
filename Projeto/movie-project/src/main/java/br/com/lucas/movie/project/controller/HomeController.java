package br.com.lucas.movie.project.controller;

import br.com.lucas.movie.project.model.Movie;
import br.com.lucas.movie.project.model.MovieStatus;
import br.com.lucas.movie.project.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/home")
public class HomeController {
    @Autowired
    private MovieRepository repository;

    @GetMapping
    public ModelAndView home() {
        List<Movie> movies = repository.findAll();
        ModelAndView mv = new ModelAndView("/home");
        mv.addObject("movies", movies);
        return mv;
    }

    @GetMapping("/{status}")
    public ModelAndView porStatus(@PathVariable("status") String status) {
        List<Movie> movies = repository.findByStatus(MovieStatus.valueOf(status.toUpperCase()));
        ModelAndView mv = new ModelAndView("/home");
        mv.addObject("movies", movies);
        return mv;
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public String onError() {
        return "redirect:/home";
    }
}
