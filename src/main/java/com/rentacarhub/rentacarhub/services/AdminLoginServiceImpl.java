package com.rentacarhub.rentacarhub.services;

import com.rentacarhub.rentacarhub.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminLoginServiceImpl implements AdminLoginService {

    @Autowired
    private AdminServices adminServices;

    @Override
    public Admin authenticateAdmin(String email, String password) {
        // Implement your authentication logic here
        // Example: Check if the provided username and password match an admin in the database
        Admin admin = adminServices.getAdminByEmail(email);

        // Check if admin exists and the password matches
        if(admin != null && admin.getPassword().equals(password))
            return admin ;

        return null;
    }
}