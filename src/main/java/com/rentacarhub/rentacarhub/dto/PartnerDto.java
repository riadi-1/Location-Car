package com.rentacarhub.rentacarhub.dto;

import com.rentacarhub.rentacarhub.entity.Partner;
import com.rentacarhub.rentacarhub.services.PartnerServices;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.beans.BeanProperty;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PartnerDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String password;
    private String phone;
    private String email;
    private String address;
    private Number carCount;

    public static Partner getPartner(PartnerDto partnerDto){
        Partner partner = new Partner();
        BeanUtils.copyProperties(partnerDto,partner);
        return partner;
    }


    public static PartnerDto getPartnerDto(Partner partner){
        PartnerDto partnerDto = new PartnerDto();
        BeanUtils.copyProperties(partner,partnerDto);
        return partnerDto;
    }


//    public static List<PartnerDto> getPartnerDtoList(List<Partner> partner){
//        List<PartnerDto> partnerDto = new ArrayList<>();
//        for(Partner partner1 : partner) {
//            PartnerDto partnerDto1 = new PartnerDto();
//            BeanUtils.copyProperties(partner, partnerDto1);
//            partnerDto1.setCarCount();
//
//        }
//        return partnerDto;
//    }

}
