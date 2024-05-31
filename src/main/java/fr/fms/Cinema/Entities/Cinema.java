package fr.fms.Cinema.Entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import org.springframework.data.annotation.Id;

import java.util.List;


public class Cinema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    public String name;
    public String address;

    @ManyToOne
    private Cinema cinema;

    @OneToMany(mappedBy = "movie")
    private List<Show> show;
}
