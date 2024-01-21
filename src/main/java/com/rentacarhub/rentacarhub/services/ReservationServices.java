package com.rentacarhub.rentacarhub.services;

import com.rentacarhub.rentacarhub.entity.Admin;
import com.rentacarhub.rentacarhub.entity.RentalHistory;
import com.rentacarhub.rentacarhub.entity.Reservation;
import com.rentacarhub.rentacarhub.entity.User;
import com.rentacarhub.rentacarhub.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReservationServices {

    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private RentalHistoryServices rentalHistoryServices;

    public Reservation set(Reservation reservation){
       return reservationRepository.save(reservation);
    }

    public List<Reservation> findAll(){
        return reservationRepository.findAll();
    }


    public List<Reservation> findAllById(Long id){
        return  reservationRepository.findAllById(List.of(id));
    }


    public Long totalRent(){
        return reservationRepository.totalRent();
    }

}
