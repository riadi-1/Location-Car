package com.rentacarhub.rentacarhub.controller;

import com.rentacarhub.rentacarhub.dto.CarDto;
import com.rentacarhub.rentacarhub.entity.Car;
import com.rentacarhub.rentacarhub.services.CarServices;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CarServices carServices ;



    @Transactional
    @PostMapping(path="/save")
    public ResponseEntity<?> save(@RequestBody CarDto carDtop){
        Car car = CarDto.getCar(carDtop);
        return new ResponseEntity<>(carServices.save(car), HttpStatus.OK);
    }


    @GetMapping
    public ResponseEntity<List<Car>> findAll(){
        return new ResponseEntity<>(carServices.findAll(),HttpStatus.OK);
    }

    @GetMapping("/{car_id}")
    public ResponseEntity<?> updateIsAvailable(@PathVariable("car_id") Long id){
        carServices.updateAvailable(id,true);
        return new ResponseEntity<>("update",HttpStatus.OK);
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCar(@PathVariable("id") Long carId){
        Car car = carServices.findCarById(carId);
        if (car != null) {
            carServices.deleteCar(car);
            return new ResponseEntity<>("Car removed", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Car not found", HttpStatus.NOT_FOUND);
        }
    }
   @Transactional
    @PostMapping("/car")
    public ResponseEntity<List<Car>> findAll(@RequestBody Map<String, String> loginData ){
        List<Car> cars = carServices.findModelCar(loginData.get("brand"), loginData.get("model"));
        return new ResponseEntity<>(cars,HttpStatus.OK);
    }

    @GetMapping("/partner/{partner_id}")
    public ResponseEntity<?> findPartnerCar(@PathVariable("partner_id") Long partnerID){
//        List<CarDto> carDtoList = CarDto.getCarDtoList(carServices.findPartnerCar(partnerID));
        return new ResponseEntity<>(carServices.findPartnerCar(partnerID),HttpStatus.OK);
    }

}
