package com.rentacarhub.rentacarhub.services;

import com.rentacarhub.rentacarhub.dto.TempCarDto;
import com.rentacarhub.rentacarhub.entity.TempCar;
import com.rentacarhub.rentacarhub.exception.ResourceNotFoundException;
import com.rentacarhub.rentacarhub.repository.TempCarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TempCarService {
    @Autowired
    private TempCarRepository tempCarRepository;


    public void save(TempCar tempCar){
         tempCarRepository.save(tempCar);
    }

    public List<TempCar> get(){
        return tempCarRepository.findAll();
    }
    public TempCar getById(Long id){
        return tempCarRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Car not found with id: "+id));
    }

    public List<TempCarDto> getPartnerId(Long partner_id){
        return tempCarRepository.findTempCarByPartnerId(partner_id);
    }

    public void deleteCar(Long id){
         tempCarRepository.deleteById(id);
    }

    public Long rentUpdate(String model, String brand){
        if(brand.equalsIgnoreCase("Toyota") && model.equalsIgnoreCase("Yaris")){
            return 6000L;
        }else if(brand.equalsIgnoreCase("Kia") && model.equalsIgnoreCase("Sportage")){
            return 8000L;
        }else if(brand.equalsIgnoreCase("Honda") && model.equalsIgnoreCase("City")){
            return 5000L;
        }else if(brand.equalsIgnoreCase("Suzuki") && model.equalsIgnoreCase("Swift")){
            return 5500L;
        }else if(brand.equalsIgnoreCase("Suzuki") && model.equalsIgnoreCase("Ciaz")){
            return 5800L;
        } else if(brand.equalsIgnoreCase("Toyota") && model.equalsIgnoreCase("Vitz")){
            return 4500L;
        } else if(brand.equalsIgnoreCase("E.S") && model.equalsIgnoreCase("Mira")){
            return 3800L;
        }

        return 6500L;
    }
}
