package com.rentacarhub.rentacarhub.services;

import com.rentacarhub.rentacarhub.entity.Admin;
import com.rentacarhub.rentacarhub.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserLoginServiceImpl implements UserLoginService {
    // Implement authentication logic for users

    @Autowired
    private UserServices userServices;

    @Override
    public User authenticateUser(String email, String password) {
        User user = userServices.getUserEmail(email);

        if(user != null && user.getPassword().equals(password))
        return user;

        return null;
    }
}