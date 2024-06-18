package fr.fms.Cinema.dao;
import fr.fms.Cinema.Entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RoleRepository  extends JpaRepository <AppRole, Long> {
    AppRole findByRolename(String rolename);

}
