package fr.fms.Cinema.dto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
public class ShowtimeDto {
    private Long id;
    private String hour;
    private double price;


    public ShowtimeDto( Long id, String hour, double price){
        this.id=id;
        this.hour=hour;
        this.price=price;
    }
}
