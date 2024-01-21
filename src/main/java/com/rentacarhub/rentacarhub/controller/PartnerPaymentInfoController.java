package com.rentacarhub.rentacarhub.controller;

import com.rentacarhub.rentacarhub.services.PartnerPaymentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/partnerPaymentInfo")
public class PartnerPaymentInfoController {
    @Autowired
    PartnerPaymentInfoService partnerPaymentInfoService;
    @GetMapping
    public ResponseEntity<?> findAll(){
        return new ResponseEntity<>(partnerPaymentInfoService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/{partner_id}")
    public ResponseEntity<?> findPartner(@PathVariable("partner_id") Long id){
        return new ResponseEntity<>(partnerPaymentInfoService.findPartner(id), HttpStatus.OK);
    }

}



