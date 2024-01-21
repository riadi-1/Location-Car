package com.rentacarhub.rentacarhub.repository;

import com.rentacarhub.rentacarhub.entity.Partner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PartnerRepository extends JpaRepository<Partner,Long> {
    public Partner getPartnersByEmail(String email);

    @Query("select p , count(c) from Partner  p left join p.cars c GROUP BY p")
    public List<Object[]> findAllPartnerCar();
    @Query("select count(c) from Partner  p left join p.cars c GROUP BY p having p.id = :partnerId")
    public Long findPartnerCar(Long partnerId);

}
