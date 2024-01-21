package com.rentacarhub.rentacarhub.services;

import com.rentacarhub.rentacarhub.entity.User;

public interface UserLoginService {
    User authenticateUser(String email, String password);

}
