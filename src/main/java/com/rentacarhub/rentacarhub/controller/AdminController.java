package com.rentacarhub.rentacarhub.controller;

import com.rentacarhub.rentacarhub.dto.AdminDto;
import com.rentacarhub.rentacarhub.dto.CarDto;
import com.rentacarhub.rentacarhub.dto.TempCarDto;
import com.rentacarhub.rentacarhub.entity.Admin;
import com.rentacarhub.rentacarhub.entity.Car;
import com.rentacarhub.rentacarhub.entity.Reservation;
import com.rentacarhub.rentacarhub.entity.TempCar;
import com.rentacarhub.rentacarhub.services.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminServices adminServices;
    @Autowired
    ReservationServices reservationServices;
    @Autowired
    private AdminLoginService adminLoginService;

    @Autowired
    private TempCarService tempCarService;
    @Autowired
    private CarServices carServices;


//    @PostMapping("/admin/set")
//    public ResponseEntity<?> saveAdmin(@RequestBody Admin admin){
//        admin = adminServices.save(admin);
//        return new ResponseEntity<>(admin,HttpStatus.OK);
//    }


    // add admin
    @Transactional
    @PostMapping()
    public ResponseEntity<?> saveAdmin(@RequestBody AdminDto adminDto) {
        try {
            // Save the admin
            Admin admin;
            admin = AdminDto.getAdmin(adminDto);
            adminDto = AdminDto.getAdminDto(adminServices.save(admin));
            return new ResponseEntity<>(adminDto, HttpStatus.OK);
        } catch (Exception e) {
            // Handle validation or data type mismatch errors
            return new ResponseEntity<>("Invalid data or data type mismatch", HttpStatus.BAD_REQUEST);
        }


    }

    //show admin using id
    @GetMapping("/{admin_id}")
    public ResponseEntity<?> findAdmin(@PathVariable("admin_id") Long id) {
        AdminDto adminDto;
        adminDto = AdminDto.getAdminDto(adminServices.getAdmin(id));
        return new ResponseEntity<>(adminDto, HttpStatus.OK);
    }

    @GetMapping("/admin")
    public ResponseEntity<?> findAllAdmin() {
        List<Admin> admin = adminServices.getAdmin();
        return new ResponseEntity<>(admin, HttpStatus.OK);
    }


    @Transactional
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> loginData) {
        Admin authenticatedAdmin = adminLoginService.authenticateAdmin(loginData.get("email"), loginData.get("password"));

        if (authenticatedAdmin != null) {
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Login successful");
            response.put("admin", authenticatedAdmin); // Include admin information in the response
            return ResponseEntity.ok(response);
        } else {
            // Handle other cases
            Map<String, String> response = new HashMap<>();
            response.put("error", "Login failed");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }

    }

    @GetMapping("/cars")
    public ResponseEntity<List<Car>> findAll(){
        List<Car> carDtos = carServices.findAll();
        return new ResponseEntity<>(carDtos,HttpStatus.OK);
    }



}
