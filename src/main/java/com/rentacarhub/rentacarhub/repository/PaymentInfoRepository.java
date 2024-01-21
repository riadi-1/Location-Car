package com.rentacarhub.rentacarhub.repository;

import com.rentacarhub.rentacarhub.entity.PaymentInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentInfoRepository extends JpaRepository<PaymentInfo,Long> {
    public List<PaymentInfo> findAllByCreditCard_Id(Long id);
}
