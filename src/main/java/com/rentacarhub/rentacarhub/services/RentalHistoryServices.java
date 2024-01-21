package com.rentacarhub.rentacarhub.services;

import com.rentacarhub.rentacarhub.entity.Car;
import com.rentacarhub.rentacarhub.entity.RentalHistory;
import com.rentacarhub.rentacarhub.entity.User;
import com.rentacarhub.rentacarhub.repository.RentalHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentalHistoryServices {
    @Autowired
    private RentalHistoryRepository rentalHistoryRepository;
    @Autowired
    private UserServices userServices;

    public void saveHistory(RentalHistory rentalHistory){
        rentalHistoryRepository.save(rentalHistory);
    }


    public List<RentalHistory> getHistory(Long userId){
        User user = userServices.findById(userId) ;

        return rentalHistoryRepository.findRentalHistoriesByUser(user);

    }


    public List<RentalHistory> getHistory(){
        return rentalHistoryRepository.findAll();

    }
    public Long totalRent(){
        return rentalHistoryRepository.totalRent();
    }

}
