package fr.fms.Cinema.web;


import fr.fms.Cinema.Entities.Customer;
import fr.fms.Cinema.Entities.Order;
import fr.fms.Cinema.Entities.OrderItem;
import fr.fms.Cinema.Mapper.CustomerMapper;
import fr.fms.Cinema.Mapper.OrderItemMapper;
import fr.fms.Cinema.Mapper.OrderMapper;
import fr.fms.Cinema.dao.CustomerRepository;
import fr.fms.Cinema.dao.OrderItemRepository;
import fr.fms.Cinema.dao.OrderRepository;
import fr.fms.Cinema.dto.CustomerDto;
import fr.fms.Cinema.dto.OrderDto;
import fr.fms.Cinema.dto.OrderItemDto;
import fr.fms.Cinema.service.ImplBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.jaxb.SpringDataJaxb;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Objects;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class OrderController {

    @Autowired
    private ImplBusinessService implBusinessService;
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;
    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderItemMapper orderItemMapper;

    @PostMapping("/customer")
    public ResponseEntity<Customer> saveCustomer(@RequestBody CustomerDto customerDto) {
        Customer customer = implBusinessService.saveCustomer(customerMapper.mapToEntity(customerDto));
        if (Objects.isNull(customer)) {
            return ResponseEntity.noContent().build();
        }
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(customer.getId())
                .toUri();
        return ResponseEntity.created(location).body(customer);
    }

    @PostMapping("/order")
    public ResponseEntity<Order> saveOrder(@RequestBody OrderDto orderDto) {
        Order order = implBusinessService.saveOrder(orderMapper.mapToEntity(orderDto));
        if (Objects.isNull(order)) {
            return ResponseEntity.noContent().build();
        }
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(order.getId())
                .toUri();
        return ResponseEntity.created(location).body(order);
    }

    @PostMapping("/orderItem")
    public ResponseEntity<OrderItem> saveOrderItem(@RequestBody OrderItemDto orderItemDto){
        OrderItem orderItem = implBusinessService.saveOrderItem(orderItemMapper.mapToEntity(orderItemDto));
        if(Objects.isNull(orderItem)){
            return ResponseEntity.noContent().build();
        }
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(orderItem.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }


    @GetMapping("/order/{id}")
    public Order getOrderByCustomerId(@PathVariable("id")Long id){
        return implBusinessService.getOrder(id);
    }

    @GetMapping("/customer/{id}")
    public Customer getCustomer(@PathVariable("id") Long id){
        return implBusinessService.getCustomerById(id);
    }

}
