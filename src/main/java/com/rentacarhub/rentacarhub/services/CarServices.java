package com.rentacarhub.rentacarhub.services;

import com.rentacarhub.rentacarhub.entity.Car;
import com.rentacarhub.rentacarhub.exception.ResourceNotFoundException;
import com.rentacarhub.rentacarhub.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServices {

    @Autowired
    private CarRepository carRepository;


    public Car save(Car car){
        return carRepository.save(car);
    }

    public Car findCarById(Long id){
        return carRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Car not found with id: "+id));
    }

    public List<Car> findAll(){
        return carRepository.findAll();
    }

    public void updateAvailable(Long id, boolean isAvailable){
        carRepository.updateIsAvailable(id, isAvailable);
    }
    public void deleteCar(Car car){
        carRepository.delete(car);
    }

    public List<Car> findModelCar(String brand,String model){
        return carRepository.findCarByBrandAndModel(brand,model);
    }

    public List<Car> findPartnerCar(Long partnerID){
        return carRepository.findCarByPartnerId(partnerID);
    }

}
