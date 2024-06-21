package fr.fms.Cinema.dto;

import fr.fms.Cinema.Entities.Order;
import fr.fms.Cinema.Entities.ShowTime;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder

public class OrderItemDto {
    private int quantity;
    private double price;
    private ShowTime showTime;
    private Order order;

    public OrderItemDto (int quantity, double price, ShowTime showTime, Order order){
        this.quantity=quantity;
        this.price=price;
        this.showTime=showTime;
        this.order = order;
    }
}
