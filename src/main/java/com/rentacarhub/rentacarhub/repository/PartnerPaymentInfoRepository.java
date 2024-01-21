package com.rentacarhub.rentacarhub.repository;

import com.rentacarhub.rentacarhub.entity.PartnerPaymentInfo;
import com.rentacarhub.rentacarhub.entity.PaymentInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PartnerPaymentInfoRepository extends JpaRepository<PartnerPaymentInfo,Long> {

    public List<PartnerPaymentInfo> findPartnerPaymentInfoByPartner_Id(Long id);

}
