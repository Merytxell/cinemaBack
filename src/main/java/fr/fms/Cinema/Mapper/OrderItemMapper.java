package fr.fms.Cinema.Mapper;


import fr.fms.Cinema.Entities.OrderItem;
import fr.fms.Cinema.dto.OrderItemDto;
import org.springframework.stereotype.Component;

@Component
public class OrderItemMapper {

    public OrderItemDto mapToDto (OrderItem orderItem){
        OrderItemDto orderItemDto = OrderItemDto.builder()
                .quantity(orderItem.getQuantity())
                .price(orderItem.getPrice())
                .showTime(orderItem.getShowTime())
                .order(orderItem.getOrder())
                .build();

        return orderItemDto;
    }

    public OrderItem mapToEntity (OrderItemDto orderItemDto){
        OrderItem orderItem = OrderItem.builder()
                .quantity(orderItemDto.getQuantity())
                .price(orderItemDto.getPrice())
                .showTime(orderItemDto.getShowTime())
                .order(orderItemDto.getOrder())
                .build();

        return orderItem;
    }
}
