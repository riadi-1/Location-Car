package com.rentacarhub.rentacarhub.services;

import com.rentacarhub.rentacarhub.entity.Reservation;
import com.rentacarhub.rentacarhub.entity.User;
import com.rentacarhub.rentacarhub.exception.ResourceNotFoundException;
import com.rentacarhub.rentacarhub.repository.ReservationRepository;
import com.rentacarhub.rentacarhub.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserServices {

    @Autowired
    private UserRepository userRepository;

    public User setUser(User user){
       return userRepository.save(user);
    }




    public List<User> getData(){
        return  userRepository.findAll();
    }

    public User findById(Long id) {
        return   userRepository.findById(id).orElse(null);
    }
    public User getUserEmail(String email){
        return userRepository.getUserByEmail(email);
    }
}
