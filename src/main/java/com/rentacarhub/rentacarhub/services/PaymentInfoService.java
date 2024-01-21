package com.rentacarhub.rentacarhub.services;


import com.rentacarhub.rentacarhub.entity.PaymentInfo;
import com.rentacarhub.rentacarhub.repository.PaymentInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentInfoService {

    @Autowired
    PaymentInfoRepository paymentInfoRepository;
    public void savePayment(PaymentInfo paymentInfo){
        paymentInfoRepository.save(paymentInfo);
    }

    public List<PaymentInfo> getPayment(Long id){
        return paymentInfoRepository.findAllByCreditCard_Id(id);
    }
}
