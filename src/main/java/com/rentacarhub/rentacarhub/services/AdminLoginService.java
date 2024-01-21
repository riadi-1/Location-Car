package com.rentacarhub.rentacarhub.services;

import com.rentacarhub.rentacarhub.entity.Admin;

public interface AdminLoginService {
    Admin authenticateAdmin(String email, String password);

}
