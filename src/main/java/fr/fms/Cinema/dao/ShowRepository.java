package fr.fms.Cinema.dao;

import fr.fms.Cinema.Entities.Show;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowRepository extends JpaRepository <Show, Long>{
}
