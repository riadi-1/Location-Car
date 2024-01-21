package com.rentacarhub.rentacarhub.entity;

import com.rentacarhub.rentacarhub.repository.ReservationRepository;
import com.rentacarhub.rentacarhub.services.CarServices;
import com.rentacarhub.rentacarhub.services.RentalHistoryServices;
import com.rentacarhub.rentacarhub.services.ReservationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
@EnableScheduling
@Component
//@EnableScheduling
public class ReservationCleanupTask {
    @Autowired
    private ReservationServices reservationServices;
    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private RentalHistoryServices rentalHistoryServices;
    @Autowired
    private CarServices carServices;

    @Scheduled(cron = "0/30 * * * * *")// Define a schedule (e.g., every hour)
    public void removeExpiredReservations() {
        LocalDateTime currentDateTime = LocalDateTime.now();
        // Find and delete expired reservations
        List<Reservation> expiredReservations = reservationRepository.findByEndDateBefore(currentDateTime);
        for(Reservation reservation : expiredReservations){
            RentalHistory rentalHistory = new RentalHistory();
            rentalHistory.setUser(reservation.getUser());
            rentalHistory.setCar(reservation.getCar());
            rentalHistory.setEndDate(reservation.getEndDate());
            rentalHistory.setRentPerDay(reservation.getRentPerDay());
            rentalHistory.setStartDate(reservation.getStartDate());
            rentalHistory.setRentPerDay(reservation.getRentPerDay());
            rentalHistoryServices.saveHistory(rentalHistory);
            carServices.updateAvailable(reservation.getCar().getId(),true);

            reservationRepository.delete(reservation);
        }
    }
}
