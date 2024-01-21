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
public class RentalHistoryDto {
    private Long id;
    private String brand;
    private String model;
    private String registrationNumber;
    private static final String states = "inActive";
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Long rentPerDay;


    public static RentalHistory getRentalHistory(RentalHistoryDto rentalHistoryDto){
        RentalHistory rentalHistory = new RentalHistory();
        BeanUtils.copyProperties(rentalHistoryDto,rentalHistory);
        rentalHistory.setRentPerDay(rentalHistoryDto.getRentPerDay());
        return rentalHistory;
    }


    public static RentalHistoryDto getRentalHistoryDto(RentalHistory rentalHistory){
        RentalHistoryDto rentalHistoryDto = new RentalHistoryDto();
        BeanUtils.copyProperties(rentalHistory, rentalHistoryDto);
        rentalHistoryDto.setModel(rentalHistory.getCar().getModel());
        rentalHistoryDto.setBrand(rentalHistory.getCar().getBrand());
        rentalHistoryDto.setRegistrationNumber(rentalHistory.getCar().getRegistrationNumber());
        rentalHistoryDto.setRentPerDay(rentalHistoryDto.getRentPerDay());
        return rentalHistoryDto;
    }

    public static List<RentalHistoryDto> getReservationDtoList(List<RentalHistory> rentalHistories) {
        List<RentalHistoryDto> reservationDtoList = new ArrayList<>();

        for (RentalHistory rentalHistory : rentalHistories) {
            RentalHistoryDto rentalHistoryDto = new RentalHistoryDto();
            BeanUtils.copyProperties(rentalHistory, rentalHistoryDto);

            // Assuming you have a Car property in Reservation

                rentalHistoryDto.setModel(rentalHistory.getCar().getModel());
                rentalHistoryDto.setBrand(rentalHistory.getCar().getBrand());
                rentalHistoryDto.setRegistrationNumber(rentalHistory.getCar().getRegistrationNumber());

                rentalHistoryDto.setRentPerDay(rentalHistoryDto.getRentPerDay());
            reservationDtoList.add(rentalHistoryDto);
        }

        return reservationDtoList;
    }
}
