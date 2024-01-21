package com.rentacarhub.rentacarhub.services;

import com.rentacarhub.rentacarhub.entity.Partner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PartnerLoginServiceImpl implements PartnerLoginService {
    @Autowired
    private PartnerServices partnerServices;

    @Override
    public Partner authenticatePartner(String email, String password) {
        // Implement your authentication logic here
        // Example: Check if the provided username and password match an admin in the database
        Partner partner = partnerServices.getEmail(email);

        // Check if admin exists and the password matches
        if(partner != null && partner.getPassword().equals(password))
            return partner;

        return null;
    }

}

