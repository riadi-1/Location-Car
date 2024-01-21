package com.rentacarhub.rentacarhub.controller;

import com.rentacarhub.rentacarhub.dto.CreditCardDto;
import com.rentacarhub.rentacarhub.entity.CreditCard;
import com.rentacarhub.rentacarhub.entity.User;
import com.rentacarhub.rentacarhub.services.CreditCardServices;
import com.rentacarhub.rentacarhub.services.UserServices;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/creditcard")
public class CreditCardController {
    @Autowired
    private CreditCardServices creditCardServices;
    @Autowired
    private UserServices userServices;


    @Transactional
    @PostMapping("/{user_id}")
    public ResponseEntity<?> addCreditCard(@PathVariable ("user_id") Long id, @RequestBody CreditCardDto creditCardDto){
        User user = userServices.findById(id);
        CreditCard creditCard = new CreditCard();
        creditCard = CreditCardDto.getCreditCard(creditCardDto);
        creditCard.setUser(user);
       creditCard= creditCardServices.addCreditCard(creditCard);
       creditCardDto = CreditCardDto.getCreditCardDto(creditCard);
       return new ResponseEntity<>(creditCardDto, HttpStatus.OK);
    }

}
