package com.rentacarhub.rentacarhub.services;

import com.rentacarhub.rentacarhub.entity.Admin;
import com.rentacarhub.rentacarhub.exception.ResourceNotFoundException;
import com.rentacarhub.rentacarhub.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServices {

    @Autowired
    private  AdminRepository adminRepository;

    public Admin save(Admin admin){
        return adminRepository.save(admin);
    }

    public Admin getAdmin(Long id){
        return adminRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Admin not found with id: " + id));
    }

    public List<Admin> getAdmin(){
        return adminRepository.findAll();
    }
    public  Admin getAdminByEmail(String email){
        return adminRepository.getAdminByEmail(email);
    }


}
