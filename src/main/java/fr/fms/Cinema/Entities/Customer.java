package fr.fms.Cinema.Entities;
import lombok.*;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString @Builder @Setter @Getter
public class Customer {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String firstName;
    private String address;
    private String email;
    private String phone;

    @OneToMany(mappedBy = "customer")
    private Collection<Order> orders;
}