package fr.fms.Cinema.Mapper;

import fr.fms.Cinema.Entities.Order;
import fr.fms.Cinema.dto.OrderDto;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {

    public OrderDto mapToDto (Order order){
        OrderDto orderDto = OrderDto.builder()
                .date(order.getDate())
                .totalAmount(order.getTotalAmount())
                .customer(order.getCustomer())
                .build();

        return orderDto;
    }

    public Order mapToEntity (OrderDto orderDto){
        Order order = Order.builder()
                .date(orderDto.getDate())
                .totalAmount(orderDto.getTotalAmount())
                .customer(orderDto.getCustomer())
                .build();

        return order;
    }
}
