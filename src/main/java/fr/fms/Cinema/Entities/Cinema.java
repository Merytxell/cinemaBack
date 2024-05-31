package fr.fms.Cinema.Entities;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import javax.persistence.*;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Cinema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    public String name;
    public String address;

    @ManyToOne
    private Cinema cinema;

    @OneToMany(mappedBy = "movie")
    private List<ShowTime> showTime;

    public Cinema(Long id, String name, String address) {
        this.id=id;
        this.name=name;
        this.address=address;
    }
}
