package com.rentacarhub.rentacarhub.services;

import com.rentacarhub.rentacarhub.entity.Partner;

public interface PartnerLoginService {
    Partner authenticatePartner(String email, String password);

}
