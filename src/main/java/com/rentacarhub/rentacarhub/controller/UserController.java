package com.rentacarhub.rentacarhub.controller;

import com.rentacarhub.rentacarhub.dto.*;
import com.rentacarhub.rentacarhub.entity.Reservation;
import com.rentacarhub.rentacarhub.entity.User;
import com.rentacarhub.rentacarhub.repository.CarRepository;
import com.rentacarhub.rentacarhub.repository.ReservationRepository;
import com.rentacarhub.rentacarhub.services.CreditCardServices;
import com.rentacarhub.rentacarhub.services.UserLoginService;
import com.rentacarhub.rentacarhub.services.UserServices;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserServices userServices ;
    @Autowired
    ReservationRepository reservationRepository;
    @Autowired
    CreditCardServices creditCardServices;
    @Autowired
    UserLoginService userLoginService;
    @Autowired
    CarRepository carRepository;

    @GetMapping()
    public ResponseEntity<?> getUser(){
        return new ResponseEntity<>(userServices.getData(),HttpStatus.OK);
    }

    @Transactional
    @PostMapping("")
    public ResponseEntity<?> setUser(@RequestBody UserDto userDto){
        try{
            User user = UserDto.getUser(userDto);
            user = userServices.setUser(user);
            return new ResponseEntity<>(user,HttpStatus.OK);
        }catch (DataIntegrityViolationException e){
            HashMap<Number,String> response = new HashMap<>();
            response.put(0,"Email already exists");
            return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("/{user_id}")
    public ResponseEntity<?> findAdmin(@PathVariable("user_id") Long id) {
        UserDto userDto;
        userDto = UserDto.getUserDto(userServices.findById(id));
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    @Transactional
    @PostMapping("/changePassword/{user_id}")
    public ResponseEntity<?> updateUser(@PathVariable("user_id") Long id , @RequestBody ChangeUserPassword request){
        User user = new User();
        user = userServices.findById(id);

            String oldPassword = request.getOldPassword();
            String newPassword = request.getNewPassword();
            if (user.getPassword().equals(oldPassword)) {
                user.setPassword(newPassword);
                userServices.setUser(user);
                return new ResponseEntity<>("Password Update", HttpStatus.OK);

            }
        return new ResponseEntity<>("Wrong password",HttpStatus.CONFLICT);

    }


    @GetMapping("/creditcard/{user_id}")
    public ResponseEntity<?> creditCardDetails(@PathVariable ("user_id") Long id){
        User user = userServices.findById(id);
        CreditCardDto creditCardDto = CreditCardDto.getCreditCardDto(user.getCreditCard());
        return new ResponseEntity<>(creditCardDto,HttpStatus.OK);


    }

    @Transactional
    @PostMapping("/login")
    public ResponseEntity<?> userLogin(@RequestBody Map<String, String> loginData) {
        User isAuthenticatedUser = userLoginService.authenticateUser(loginData.get("email"), loginData.get("password"));
        UserDto userDto = UserDto.getUserDto(isAuthenticatedUser);
        System.out.println(userDto);
        if (isAuthenticatedUser != null) {

            Map<String, Object> response = new HashMap<>();
            response.put("code", "00");
            response.put("success", "Login successful");
            response.put("UserDto", userDto);
            return ResponseEntity.ok(response);
        } else {
            // Handle other cases
            Map<String, String> response = new HashMap<>();
            response.put("error", "Login failed");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }




}
