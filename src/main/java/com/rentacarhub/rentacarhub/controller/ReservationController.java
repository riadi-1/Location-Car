package com.rentacarhub.rentacarhub.controller;

import com.rentacarhub.rentacarhub.dto.ReservationDto;
import com.rentacarhub.rentacarhub.dto.UserDto;
import com.rentacarhub.rentacarhub.entity.*;
import com.rentacarhub.rentacarhub.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.util.ObjectUtils.isEmpty;

@Controller
@RequestMapping("/reservation")
public class ReservationController {

    @Autowired
    private ReservationServices reservationServices;
    @Autowired
    private UserServices userServices;
    @Autowired
    private CarServices carServices;
    @Autowired
    private PartnerPaymentInfoService partnerPaymentInfoService;
    @Autowired
    private  PaymentInfoService paymentInfoService;

//    @PostMapping("/{user_id}/{car_id}")
//    public ResponseEntity<?> setReservation(@PathVariable("user_id") Long user_id ,@PathVariable("car_id") Long car_id,
//                                            @RequestBody ReservationDto reservationDto) {
//        User user = userServices.findById(user_id);
//        Car car = carServices.findCarById(car_id);
//        if (user!=null) {
//            if(!car.getIsAvailable()){
//                return new ResponseEntity<>("Car is not available", HttpStatus.OK);
//            }
//            Reservation reservation = ReservationDto.getReservation(reservationDto);
//            reservation.setUser(user);
//            reservation.setCar(car);
//            reservation = reservationServices.set(reservation);
//            carServices.updateAvailable(car_id,false);
//            return new ResponseEntity<>(reservation, HttpStatus.OK);
//        }
//            return new ResponseEntity<>("First register  yourself", HttpStatus.OK);
//
//    }

    @PostMapping("/{user_id}/{car_id}")
    public ResponseEntity<?> setReservation(@PathVariable("user_id") Long user_id, @PathVariable("car_id") Long car_id, @RequestBody ReservationDto reservationDto) {
        User user = userServices.findById(user_id);
        if (user == null) {
            return new ResponseEntity<>("First register yourself", HttpStatus.BAD_REQUEST);
        }
        Car car = carServices.findCarById(car_id);
        if (car == null) {
            // Handle the case where the car is not found
            return new ResponseEntity<>("Car not found", HttpStatus.BAD_REQUEST);
        }
        if (!car.getIsAvailable()) {
            return new ResponseEntity<>("Car is not available", HttpStatus.BAD_REQUEST);
        }
        Reservation reservation = ReservationDto.getReservation(reservationDto);

        CreditCard creditCard = user.getCreditCard();
        if(creditCard.getCardLimit()<reservation.getRentPerDay()) {
            String message = "Limit Exceeded";
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }
        reservation.setUser(user);
        reservation.setCar(car);
        Long day = RentCalculator.calculateRent(reservation);
        reservation.setRentPerDay(car.getRentPerDay()*day);
        reservation = reservationServices.set(reservation);
        carServices.updateAvailable(car_id, false);
        partnerPaymentInfoService.addPayment(reservation);
//        String message = "Reservation done";

            PaymentInfo paymentInfo =  new PaymentInfo();
            paymentInfo.setBill(reservation.getRentPerDay());
            paymentInfo.setDate(reservation.getStartDate());
            paymentInfo.setCreditCard(creditCard);
            creditCard.setCardLimit(creditCard.getCardLimit()-reservation.getRentPerDay());
            paymentInfoService.savePayment(paymentInfo);
        return new ResponseEntity<>(reservation, HttpStatus.OK);
    }

    @GetMapping("/{user_id}")
    public ResponseEntity<?> userReservation(@PathVariable("user_id") Long id){
        User user = userServices.findById(id);
        List<Reservation> reservationList = user.getReservations();
        List<ReservationDto> reservationDto = ReservationDto.getReservationDtoList(reservationList);
        return new ResponseEntity<>(reservationDto,HttpStatus.OK);

    }


    @GetMapping()
    public ResponseEntity<?> get(){
        return new ResponseEntity<>(reservationServices.findAll(),HttpStatus.OK);
    }


    @GetMapping("/totalrent")
    public ResponseEntity<?> totalRent(){
        Long rent = reservationServices.totalRent();
        return new ResponseEntity<>(rent,HttpStatus.OK);

    }


}
