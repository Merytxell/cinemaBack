package fr.fms.Cinema.service;

import fr.fms.Cinema.Entities.*;
import fr.fms.Cinema.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ImplBusinessService implements  IBusinessService{

    @Autowired
    CinemaRepository cinemaRepository;

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    ShowRepository showRepository;

    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    OrderItemRepository orderItemRepository;

    @Autowired
    OrderRepository orderRepository;

    public List<Cinema> getAllCinemas() {
        return cinemaRepository.findAll();
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public List<ShowTime> getAllShowTimes() {
        return showRepository.findAll();
    }

    @Override
    public List<Cinema> findByName(String keyword) {
        return cinemaRepository.findByNameContaining(keyword);
    }

    public List<Movie> getMovieByCinema(Long cinemaId) {
        return movieRepository.findByCinemaId(cinemaId);
    }

    public List<ShowTime> getShowByMovie(Long movieId) {
        return showRepository.findByMovieId(movieId);
    }

    @Override
    public Optional<Movie> readMovie(Long id){
        return movieRepository.findById(id);
    }

    @Override
    public Movie saveMovie(Movie movie) {
        return movieRepository.save(movie);
    }
    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer getCustomerById(Long customerId) {
        Optional<Customer> optional = customerRepository.findById(customerId);
        return (optional.isPresent()) ? optional.get() : null;
    }

    @Override
    public Order saveOrder(Order order) {
        if (order.getCustomer() != null && order.getCustomer().getId() == null) {
            Customer savedCustomer = customerRepository.save(order.getCustomer());
            order.setCustomer(savedCustomer);
        }
        return orderRepository.save(order);
    }

    @Override
    public Order getOrder(Long id) {
        return orderRepository.findByCustomerIdOrderByIdDesc(id);
    }


    @Override
    public OrderItem saveOrderItem(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }

}
