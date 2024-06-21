package fr.fms.Cinema.Mapper;


import fr.fms.Cinema.Entities.Customer;
import fr.fms.Cinema.dto.CustomerDto;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {
    public CustomerDto mapToDto (Customer customer){
        CustomerDto customerDto = CustomerDto.builder()
                .name(customer.getName())
                .firstName(customer.getFirstName())
                .address(customer.getAddress())
                .email(customer.getEmail())
                .phone(customer.getPhone())
                .build();

        return customerDto;
    }

    public Customer mapToEntity (CustomerDto customerDto){
        Customer customer = Customer.builder()
                .name(customerDto.getName())
                .firstName(customerDto.getFirstName())
                .address(customerDto.getAddress())
                .email(customerDto.getEmail())
                .phone(customerDto.getPhone())
                .build();

        return customer;
    }

}
