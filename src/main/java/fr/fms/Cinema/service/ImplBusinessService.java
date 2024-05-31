package fr.fms.Cinema.service;

import fr.fms.Cinema.Entities.Cinema;
import fr.fms.Cinema.dao.CinemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ImplBusinessService implements  IBusinessService{

    @Autowired
    CinemaRepository cinemaRepository;


    public List<Cinema> getCinema() {
        return cinemaRepository.findAll();
    }
}
