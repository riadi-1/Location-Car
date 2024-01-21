package com.rentacarhub.rentacarhub.dto;

import com.rentacarhub.rentacarhub.entity.Car;
import com.rentacarhub.rentacarhub.entity.TempCar;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarDto {
    private Long id;
    private String brand;
    private String model;
    private Integer year;
    private String color;
    private String registrationNumber;
    private Boolean isAvailable;
    private Long rentPerDay;



    public static Car getCar(CarDto carDto){
        Car car = new Car();
        BeanUtils.copyProperties(carDto,car);
        return car;
    }

    public static CarDto getCarDto(Car car){
        CarDto carDto = new CarDto();
        BeanUtils.copyProperties(car, carDto);
        return carDto;
    }

    public static List<CarDto> getCarDtoList(List<Car> car){
        List<CarDto> carDto = new ArrayList<>();
        BeanUtils.copyProperties(car, carDto);
        return carDto;
    }


    public static Car TempCarToCar(TempCar tempCar){
        Car car = new Car();
        car.setBrand(tempCar.getBrand());
        car.setColor(tempCar.getColor());
        car.setModel(tempCar.getModel());
        car.setIsAvailable(true);
        car.setYear(tempCar.getYear());
        car.setPartner(tempCar.getPartner());
        car.setRegistrationNumber(tempCar.getRegistrationNumber());
        return car;
    }
}
