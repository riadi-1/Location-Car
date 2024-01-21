package com.rentacarhub.rentacarhub.controller;

import com.rentacarhub.rentacarhub.dto.AdminDto;
import com.rentacarhub.rentacarhub.dto.RentalHistoryDto;
import com.rentacarhub.rentacarhub.entity.Admin;
import com.rentacarhub.rentacarhub.services.RentalHistoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/rental")
public class RentalHistoryController {

    @Autowired
    RentalHistoryServices rentalHistoryServices;

    @GetMapping("/{userId}")
    public ResponseEntity<?> getRental(@PathVariable("userId") Long id) {
        try {
            List<RentalHistoryDto> rentalHistoryDtoList = new ArrayList<>();
            rentalHistoryDtoList = RentalHistoryDto.getReservationDtoList(rentalHistoryServices.getHistory(id));
            return new ResponseEntity<>(rentalHistoryDtoList, HttpStatus.OK);
        } catch (Exception e) {
            // Handle validation or data type mismatch errors
            return new ResponseEntity<>("Invalid data or data type mismatch", HttpStatus.BAD_REQUEST);
        }


    }

    @GetMapping()
    public ResponseEntity<?> getRentalAll() {
        try {
          return new ResponseEntity<>(rentalHistoryServices.getHistory(),HttpStatus.OK);
        } catch (Exception e) {
            // Handle validation or data type mismatch errors
            return new ResponseEntity<>("Invalid data or data type mismatch", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/totalrent")
    public ResponseEntity<?> totalRent(){
        Long rent = rentalHistoryServices.totalRent();
        return new ResponseEntity<>(rent,HttpStatus.OK);

    }


}
