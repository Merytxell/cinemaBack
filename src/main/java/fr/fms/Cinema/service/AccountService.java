package fr.fms.Cinema.service;

import fr.fms.Cinema.Entities.AppRole;
import fr.fms.Cinema.Entities.AppUser;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AccountService {
    public AppUser saveUser (AppUser user);
    public AppRole saveRole (AppRole role);
    public void addRoleToUser (String username, String rolename);
    public AppUser findUserByUsername (String Username);
    ResponseEntity<List<AppUser>>listUsers();


}
