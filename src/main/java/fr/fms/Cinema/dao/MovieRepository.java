package fr.fms.Cinema.dao;

import fr.fms.Cinema.Entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository <Movie, Long> {

    List<Movie> findByCinemaId(Long cinemaId);
}
