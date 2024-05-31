package fr.fms.Cinema.web;


import fr.fms.Cinema.Entities.Cinema;
import fr.fms.Cinema.Entities.Movie;
import fr.fms.Cinema.Entities.ShowTime;
import fr.fms.Cinema.service.ImplBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/movie")
    public List<Movie> getMovie(){
        return implBusinessService.getMovie();
    }

    @GetMapping("/ShowTime")
    public List<ShowTime> getShowTime() {
        return implBusinessService.getShowTime();
    };

    @GetMapping("/movie/cinema/{id}")
    public List<Movie> trainingsByCategory(@PathVariable("id") Long id){
        return implBusinessService.getMovieByCinema(id);
    }
}
