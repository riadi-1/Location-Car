package com.rentacarhub.rentacarhub.entity;

import java.util.Date;

public class RentCalculator {
    public static Long calculateRent(Reservation record) {
        long daysDifference = java.time.temporal.ChronoUnit.DAYS.between(record.getStartDate(),record.getEndDate());
        // Handle the case where record is not of type Record
        return daysDifference;
    }
}
