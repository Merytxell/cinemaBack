package fr.fms.Cinema.service;

import fr.fms.Cinema.Entities.Cinema;
import fr.fms.Cinema.Entities.Movie;
import fr.fms.Cinema.Entities.ShowTime;
import fr.fms.Cinema.dao.CinemaRepository;
import fr.fms.Cinema.dao.MovieRepository;
import fr.fms.Cinema.dao.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ImplBusinessService implements  IBusinessService{

    @Autowired
    CinemaRepository cinemaRepository;

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    ShowRepository showRepository;

    public List<Cinema> getCinema() {
        return cinemaRepository.findAll();
    }

    public List<Movie> getMovie() {
        return movieRepository.findAll();
    }

    public List<ShowTime> getShowTime() {
        return showRepository.findAll();
    }

    public List<Movie> getMovieByCinema(Long cinemaId) {
        return movieRepository.findByCinemaId(cinemaId);
    }

    public List<ShowTime> getShowByMovie(Long movieId) {
        return showRepository.findByMovieId(movieId);
    }
}
