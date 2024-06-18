package fr.fms.Cinema.service;

import fr.fms.Cinema.Entities.AppRole;
import fr.fms.Cinema.Entities.AppUser;
import fr.fms.Cinema.dao.RoleRepository;
import fr.fms.Cinema.dao.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import javax.transaction.Transactional;
import java.util.List;


@Service @Transactional @Slf4j

public class AccountServiceImpl implements  AccountService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    public BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public AppUser saveUser(AppUser user) {
      String hashPw = bCryptPasswordEncoder.encode(user.getPassword());
      user.setPassword(hashPw);
      log.info("sauvegarde d'un nouvel utilisateur", user);
      return userRepository.save(user);
    }

    @Override
    public AppRole saveRole(AppRole role) {
      log.info("sauvegarde d'un nouveau role");
      return roleRepository.save(role);

    }

    @Override
    public void addRoleToUser(String username, String rolename) {

        AppRole role = roleRepository.findByRolename(rolename);
        AppUser user = userRepository.findByUsername(username);
        user.getRoles().add(role);
        log.info("association d'un rôle à l'utilisateur");

    }

    @Override
    public AppUser findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public ResponseEntity<List<AppUser>> listUsers() {
        return ResponseEntity.ok().body(userRepository.findAll());
    }
}