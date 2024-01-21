package com.rentacarhub.rentacarhub.services;

import com.rentacarhub.rentacarhub.entity.Partner;
import com.rentacarhub.rentacarhub.exception.ResourceNotFoundException;
import com.rentacarhub.rentacarhub.repository.PartnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartnerServices {
    @Autowired
    private PartnerRepository partnerRepository;


    public void savePartner(Partner partner){
        partnerRepository.save(partner);
    }

    public Partner getPartner(Long id){
        return partnerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Partner not found with id: " + id));
    }

    public List<Partner> getPartner(){
        return partnerRepository.findAll();
    }

    public  Partner getEmail(String email){
        return partnerRepository.getPartnersByEmail(email);
    }

    public List<Object[]> findAllPartnerCar(){
        return partnerRepository.findAllPartnerCar();
    }

    public Long findPartnerCar(Long partnerId){
        return partnerRepository.findPartnerCar(partnerId);
    }

}
