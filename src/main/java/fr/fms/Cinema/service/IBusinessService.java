package fr.fms.Cinema.service;

import fr.fms.Cinema.CinemaApplication;
import fr.fms.Cinema.Entities.*;

import java.util.List;
import java.util.Optional;

public interface IBusinessService {

    List<Cinema> getAllCinemas();

    List<Movie> getAllMovies();

    List<ShowTime> getAllShowTimes();

    List<Cinema> findByName(String keyword);

    Optional<Movie> readMovie(Long id);

    Movie saveMovie(Movie movie);

    Customer saveCustomer(Customer customer);

    Customer getCustomerById(Long customerId);

    Order saveOrder(Order order);

    Order getOrder(Long id);

    OrderItem saveOrderItem(OrderItem orderItem);
}
