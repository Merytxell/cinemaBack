package fr.fms.Cinema.service;

import fr.fms.Cinema.CinemaApplication;
import fr.fms.Cinema.Entities.Cinema;
import fr.fms.Cinema.Entities.Movie;
import fr.fms.Cinema.Entities.ShowTime;

import java.util.List;
import java.util.Optional;

public interface IBusinessService {

    List<Cinema> getAllCinemas();

    List<Movie> getAllMovies();

    List<ShowTime> getAllShowTimes();

    List<Cinema> findByName(String keyword);

    Optional<Movie> readMovie(Long id);

    Movie saveMovie(Movie movie);
}
