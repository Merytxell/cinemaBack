package fr.fms.Cinema.Entities;


import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

@Entity
public class Movie {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;


    @ManyToOne
    private Cinema cinema;
}
