package com.rentacarhub.rentacarhub.dto;

import com.rentacarhub.rentacarhub.entity.Admin;
import com.rentacarhub.rentacarhub.entity.PaymentInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentInfoDto {
    private Long id;
    private LocalDateTime date;
    private Long bill;


    public static PaymentInfo getPaymentInfo( PaymentInfoDto paymentInfoDto){
        PaymentInfo paymentInfo = new PaymentInfo();
        BeanUtils.copyProperties(paymentInfoDto,paymentInfo);
        return paymentInfo;
    }


    public static PaymentInfoDto getPaymentInfoDto( PaymentInfo paymentInfo){
        PaymentInfoDto paymentInfoDto = new PaymentInfoDto();
        BeanUtils.copyProperties(paymentInfo,paymentInfoDto);
        return paymentInfoDto;
    }



}
