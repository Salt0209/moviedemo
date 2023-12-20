package com.bkacad.app.controller;

import com.bkacad.app.exceptions.DatabaseActionException;
import com.bkacad.app.models.dao.MovieDAO;
import com.bkacad.app.models.entities.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/movies")
public class MovieController {
    
    @Autowired
    private MovieDAO movieDAO;

    @RequestMapping(value={"/list",""}, method = RequestMethod.GET)
    public String listMovies(Model model) throws DatabaseActionException {
        List<Movie> movies = movieDAO.findAll();
        model.addAttribute("movies", movies);
        return "list";
    }

    @RequestMapping(value="/view/{id}", method = RequestMethod.GET)
    public String viewMovie(@PathVariable int id, Model model) throws DatabaseActionException {
        Optional<Movie> movie = movieDAO.findMovieById(id);
        model.addAttribute("movie", movie.orElse(null));
        return "view";
    }

    @RequestMapping(value="/add", method = RequestMethod.GET)
    public String showAddForm(Model model) throws DatabaseActionException {
        return "add";
    }

    @RequestMapping(value="/add", method = RequestMethod.POST)
    public String addMovie(@RequestParam String title,@RequestParam String genre,@RequestParam int yearOfRelease) throws DatabaseActionException {
        Movie creatMovie = new Movie();
        creatMovie.title = title;
        creatMovie.genre= genre;
        creatMovie.yearOfRelease=yearOfRelease;
        movieDAO.createMovie(creatMovie);
        return "redirect:/movies/list";
    }

    @RequestMapping(value="/edit/{id}", method = RequestMethod.GET)
    public String showEditForm(@PathVariable int id, Model model) throws DatabaseActionException {
        Optional<Movie> existingMovie = movieDAO.findMovieById(id);
        model.addAttribute("movie", existingMovie.orElse(null));
        return "edit";
    }

    @RequestMapping(value="/edit/{id}", method = RequestMethod.POST)
    public String updateMovie(@PathVariable int id, @RequestParam String title) throws DatabaseActionException {
        Optional<Movie> existingMovie = movieDAO.findMovieById(id);
        if (existingMovie.isPresent()) {
            movieDAO.updateMoviesTitle(id, title);
        }
        return "redirect:/movies/list";
    }

    @RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
    public String deleteMovie(@PathVariable int id) throws DatabaseActionException {
        movieDAO.deleteMovie(id);
        return "redirect:/movies/list";
    }
}
