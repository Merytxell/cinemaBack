package fr.fms.Cinema.dao;

import fr.fms.Cinema.Entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository  extends JpaRepository<AppUser, Long>  {

    AppUser findByUsername(String username);
}
