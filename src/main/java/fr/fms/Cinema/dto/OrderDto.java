package fr.fms.Cinema.dto;
import fr.fms.Cinema.Entities.Customer;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

    @Setter
    @Getter
    @Builder
    public class OrderDto {

        private Date date;
        private double totalAmount;
        private Customer customer;

        public OrderDto (Date date, double totalAmount, Customer customer){
            this.date=date;
            this.totalAmount=totalAmount;
            this.customer = customer;
        }
    }


