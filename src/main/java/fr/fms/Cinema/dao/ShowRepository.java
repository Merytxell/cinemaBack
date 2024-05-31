package fr.fms.Cinema.dao;

import fr.fms.Cinema.Entities.ShowTime;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShowRepository extends JpaRepository <ShowTime, Long>{

    List<ShowTime> findByMovieId(Long movieId);

}
