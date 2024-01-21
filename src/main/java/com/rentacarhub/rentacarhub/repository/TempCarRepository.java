package com.rentacarhub.rentacarhub.repository;

import com.rentacarhub.rentacarhub.dto.TempCarDto;
import com.rentacarhub.rentacarhub.entity.TempCar;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TempCarRepository extends JpaRepository<TempCar,Long> {

    public List<TempCarDto> findTempCarByPartnerId(Long partner_id);
}
