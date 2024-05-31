package fr.fms.Cinema.Entities;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



import java.time.LocalDateTime;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class ShowTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime dateTime;
    private int price;

    @ManyToOne
    private Movie movie;

    @ManyToOne
    private Cinema cinema;

    public ShowTime(Long id, Movie movie, LocalDateTime dateTime, Cinema cinema, int price) {
        this.id=id;
        this.movie=movie;
        this.dateTime=dateTime;
        this.cinema=cinema;
        this.price=price;
    }
}
