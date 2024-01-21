package com.rentacarhub.rentacarhub.controller;

import com.rentacarhub.rentacarhub.entity.CreditCard;
import com.rentacarhub.rentacarhub.entity.PaymentInfo;
import com.rentacarhub.rentacarhub.entity.User;
import com.rentacarhub.rentacarhub.services.CreditCardServices;
import com.rentacarhub.rentacarhub.services.PaymentInfoService;
import com.rentacarhub.rentacarhub.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/payment")
public class PaymentInfoController {
    @Autowired
    PaymentInfoService paymentInfoService;
    @Autowired
    UserServices userServices;
    @Autowired
    CreditCardServices creditCardServices;

    @GetMapping("/{user_id}")
    public ResponseEntity<?> getPayment(@PathVariable("user_id" ) Long id){
//        User user = userServices.findById(id)
        CreditCard creditCard = creditCardServices.getCard(id);
        List<PaymentInfo> paymentInfos = paymentInfoService.getPayment(creditCard.getId());
        return new ResponseEntity<>(paymentInfos, HttpStatus.OK);
    }

}
