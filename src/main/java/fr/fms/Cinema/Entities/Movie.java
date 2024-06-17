package fr.fms.Cinema.Entities;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "movie")
    @ToString.Exclude
    private List<ShowTime>showTimes = new ArrayList<>();

    @ManyToOne
    @JsonIgnoreProperties(value = "movies")
    private Cinema cinema;
}
