package com.rentacarhub.rentacarhub.repository;

import com.rentacarhub.rentacarhub.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;


public interface ReservationRepository extends JpaRepository<Reservation,Long> {
    public List<Reservation> findByEndDateBefore(LocalDateTime currentDateTime);
//    List<Reservation> findAllById(Long id);

//    public Long co
    @Query(value = "select sum(rentPerDay) from Reservation")
    public Long totalRent();
}
