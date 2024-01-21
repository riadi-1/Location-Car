package com.rentacarhub.rentacarhub.services;

import com.rentacarhub.rentacarhub.dto.CreditCardDto;
import com.rentacarhub.rentacarhub.entity.CreditCard;
import com.rentacarhub.rentacarhub.entity.User;
import com.rentacarhub.rentacarhub.repository.CreditCardRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreditCardServices {

    @Autowired
    private CreditCardRepository creditCardRepository;
    @Autowired
    private UserServices userServices;

    @Transactional
    public CreditCard addCreditCard(CreditCard creditCard){
        creditCardRepository.save(creditCard);
        return creditCard;
    }

    public CreditCard getCard(Long id){
        return creditCardRepository.findCreditCardByUserId(id);
    }

}
