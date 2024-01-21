package com.rentacarhub.rentacarhub.dto;

import com.rentacarhub.rentacarhub.entity.Car;
import com.rentacarhub.rentacarhub.entity.CreditCard;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreditCardDto {

    private Long id;
    private Long cardNumber;
    private LocalDate validThru;
    private Integer cvv;
    private Long cardLimit;



    public static CreditCard getCreditCard(CreditCardDto creditCardDto){
        CreditCard creditCards = new CreditCard();
        BeanUtils.copyProperties(creditCardDto,creditCards);
        return creditCards;
    }

    public static CreditCardDto getCreditCardDto(CreditCard creditCard ){
        CreditCardDto creditCardDto = new CreditCardDto();
        BeanUtils.copyProperties(creditCard,creditCardDto);
        return creditCardDto;
    }
}
