package fr.fms.Cinema.dao;

import fr.fms.Cinema.Entities.ShowTime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowRepository extends JpaRepository <ShowTime, Long>{
}
