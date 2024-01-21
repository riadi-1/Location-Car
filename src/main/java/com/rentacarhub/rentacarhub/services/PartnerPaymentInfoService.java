package com.rentacarhub.rentacarhub.services;

import com.rentacarhub.rentacarhub.entity.Partner;
import com.rentacarhub.rentacarhub.entity.PartnerPaymentInfo;
import com.rentacarhub.rentacarhub.entity.Reservation;
import com.rentacarhub.rentacarhub.repository.PartnerPaymentInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartnerPaymentInfoService {

    @Autowired
    private PartnerPaymentInfoRepository partnerPaymentInfoRepository ;

    public PartnerPaymentInfo addPayment(Reservation reservation){
        PartnerPaymentInfo partnerPaymentInfo = new PartnerPaymentInfo();
        partnerPaymentInfo.setPartner(reservation.getCar().getPartner());
        partnerPaymentInfo.setEndDate(reservation.getEndDate());
        partnerPaymentInfo.setStartDate(reservation.getStartDate());
        partnerPaymentInfo.setRentPerDay((long) (reservation.getRentPerDay() * 0.4));
        partnerPaymentInfo.setRegistrationNumber(reservation.getCar().getRegistrationNumber());

        return partnerPaymentInfoRepository.save(partnerPaymentInfo);
    }

    public List<PartnerPaymentInfo> findAll(){
        return partnerPaymentInfoRepository.findAll();
    }

    public List<PartnerPaymentInfo> findPartner(Long id){
        return partnerPaymentInfoRepository.findPartnerPaymentInfoByPartner_Id(id);
    }

}
