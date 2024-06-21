package fr.fms.Cinema.Entities;


import lombok.*;

import javax.persistence.*;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString
@Setter
@Getter
@Builder
public class OrderItem {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int quantity;
    private double price;

    @ManyToOne
    private ShowTime showTime;

    @ManyToOne
    private Order order;


}