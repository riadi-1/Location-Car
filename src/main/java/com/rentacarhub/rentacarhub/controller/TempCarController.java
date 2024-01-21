package com.rentacarhub.rentacarhub.controller;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.rentacarhub.rentacarhub.dto.CarDto;
import com.rentacarhub.rentacarhub.dto.TempCarDto;
import com.rentacarhub.rentacarhub.entity.Car;
import com.rentacarhub.rentacarhub.entity.Partner;
import com.rentacarhub.rentacarhub.entity.TempCar;
import com.rentacarhub.rentacarhub.repository.TempCarRepository;
import com.rentacarhub.rentacarhub.services.CarServices;
import com.rentacarhub.rentacarhub.services.PartnerServices;
import com.rentacarhub.rentacarhub.services.TempCarService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/tempCar")
public class TempCarController {

    @Autowired
    private TempCarService tempCarService;
    @Autowired
    private PartnerServices partnerServices;
    @Autowired
    private CarServices carServices;

    @Transactional
    @PostMapping("/{partner_id}")
    public ResponseEntity<?> save(@PathVariable("partner_id") Long partnerId, @RequestBody TempCarDto tempCarDto){
        TempCar tempCar = TempCarDto.getTempCar(tempCarDto);
        Partner partner = partnerServices.getPartner(partnerId);
        tempCar.setPartner(partner);
        tempCarService.save(tempCar);
        return new ResponseEntity<>(tempCar, HttpStatus.OK);

    }

    @GetMapping("/{partner_id}")
    public ResponseEntity<?> getMyCar(@PathVariable("partner_id") Long id)
    {
        List<TempCarDto> tempCarList = tempCarService.getPartnerId(id);
        return new ResponseEntity<>(tempCarList,HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getCars(){
        List<TempCar> tempCars = tempCarService.get();
        List<TempCarDto> carDtoList = TempCarDto.getTempCarDtoList(tempCars);
        return new ResponseEntity<>(carDtoList,HttpStatus.OK);
    }

    @Transactional
    @PostMapping("/approved/{car_id}")
    public ResponseEntity<?> approveCar(@PathVariable("car_id") Long car_id){
        TempCar tempCar = new TempCar();
        tempCar = tempCarService.getById(car_id);
        Car car = CarDto.TempCarToCar(tempCar);
        car.setRentPerDay(tempCarService.rentUpdate(car.getModel(),car.getBrand()));
        tempCarService.deleteCar(car_id);
        carServices.save(car);
        return new ResponseEntity<>("Car Approved ",HttpStatus.OK);
    }

    @Transactional
    @PostMapping("/disapproved/{car_id}")
    public ResponseEntity<?> disApproveCar(@PathVariable("car_id") Long car_id){
        tempCarService.deleteCar(car_id);
        return new ResponseEntity<>("Car Disapproved ",HttpStatus.OK);
    }

}
