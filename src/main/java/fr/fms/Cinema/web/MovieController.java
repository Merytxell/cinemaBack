package fr.fms.Cinema.web;


import fr.fms.Cinema.Entities.Cinema;
import fr.fms.Cinema.service.ImplBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class MovieController {

    @Autowired
    ImplBusinessService implBusinessService;

    @GetMapping("/cinema")
    public List<Cinema> getCinema(){
        return implBusinessService.getCinema();
    }
}
