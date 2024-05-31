package fr.fms.Cinema.dao;

import fr.fms.Cinema.Entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository <Movie, Long> {
}
