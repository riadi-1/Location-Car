package com.rentacarhub.rentacarhub.dto;

import com.rentacarhub.rentacarhub.entity.Car;
import com.rentacarhub.rentacarhub.entity.RentalHistory;
import com.rentacarhub.rentacarhub.entity.Reservation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationDto {
    private Long id;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Long rentPerDay ;
    private String brand;
    private String model;
    private String registrationNumber;
    private String status;
    public static Reservation getReservation(ReservationDto reservationDto){
        Reservation reservation = new Reservation();
        BeanUtils.copyProperties(reservationDto,reservation);
        return reservation;
    }



    public static ReservationDto getReservationDto(Reservation reservation){
        ReservationDto reservationDto = new ReservationDto();
        BeanUtils.copyProperties(reservation,reservationDto);
        reservationDto.setModel(reservation.getCar().getModel());
        reservationDto.setBrand(reservation.getCar().getBrand());
        reservationDto.setRegistrationNumber(reservation.getCar().getRegistrationNumber());
        return reservationDto;
    }

    public static List<ReservationDto> getReservationDtoList(List<Reservation> reservations) {
        List<ReservationDto> reservationDtoList = new ArrayList<>();

        for (Reservation reservation : reservations) {
            ReservationDto reservationDto = new ReservationDto();
            BeanUtils.copyProperties(reservation, reservationDto);

            // Assuming you have a Car property in Reservation
            Car car = reservation.getCar();
            if (car != null) {
                reservationDto.setModel(car.getModel());
                reservationDto.setBrand(car.getBrand());
                reservationDto.setRegistrationNumber(reservation.getCar().getRegistrationNumber());
            }

            reservationDtoList.add(reservationDto);
        }

        return reservationDtoList;
    }



}
