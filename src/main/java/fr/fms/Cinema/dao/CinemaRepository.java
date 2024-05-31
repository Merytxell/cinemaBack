package fr.fms.Cinema.dao;

import fr.fms.Cinema.Entities.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CinemaRepository extends JpaRepository <Cinema, Long> {
}
