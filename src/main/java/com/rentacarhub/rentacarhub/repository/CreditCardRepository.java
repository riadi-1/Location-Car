package com.rentacarhub.rentacarhub.repository;

import com.rentacarhub.rentacarhub.entity.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditCardRepository extends JpaRepository<CreditCard,Long> {
    public CreditCard findCreditCardByUserId(Long id);
}
