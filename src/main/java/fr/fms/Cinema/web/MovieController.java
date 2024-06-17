package fr.fms.Cinema.web;


import fr.fms.Cinema.Entities.Cinema;
import fr.fms.Cinema.Entities.Movie;
import fr.fms.Cinema.Entities.ShowTime;
import fr.fms.Cinema.service.ImplBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class MovieController {

    @Autowired
    ImplBusinessService implBusinessService;


    @GetMapping("/cinemas")
    public List<Cinema> getCinema(){
        List<Cinema> cinemas = implBusinessService.getAllCinemas();
        System.out.println(cinemas);
        return cinemas;
    }

    @GetMapping("/movies")
    public List<Movie> getMovie(){
        List<Movie> movies = implBusinessService.getAllMovies();
        System.out.println(movies);
       return movies;

    }

    @GetMapping("/showTimes")
    public ResponseEntity<List<ShowTime>> getShowTime() {
        List<ShowTime> showTimes = implBusinessService.getAllShowTimes();
        return ResponseEntity.ok(showTimes);
    }

    @GetMapping("showTimes/movies/{id}")
    public ResponseEntity<List<ShowTime>> showTimeByMovie(@PathVariable("id") Long id){
        List<ShowTime> showTimes = implBusinessService.getShowByMovie(id);
        return ResponseEntity.ok(showTimes);
    }

    @GetMapping("/movies/cinemas/{id}")
    public ResponseEntity<List<Movie>> movieByCinema(@PathVariable("id") Long id){
        List<Movie> movies = implBusinessService.getMovieByCinema(id);
        return ResponseEntity.ok(movies);
    }


    @GetMapping("/cinemas/search/{keyword}")
    public List<Cinema>searchCinemas (@PathVariable("keyword") String  Keyword){
        return implBusinessService.findByName(Keyword);
    }
}
