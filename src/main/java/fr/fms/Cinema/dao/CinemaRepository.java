package fr.fms.Cinema.dao;

import fr.fms.Cinema.Entities.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CinemaRepository extends JpaRepository <Cinema, Long> {


    List<Cinema> findByNameContaining(String name);
}
