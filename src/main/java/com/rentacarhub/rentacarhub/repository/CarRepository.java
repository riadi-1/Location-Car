package com.rentacarhub.rentacarhub.repository;

import com.rentacarhub.rentacarhub.entity.Car;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CarRepository extends JpaRepository<Car,Long>{
    @Modifying
    @Query("UPDATE Car c SET c.isAvailable = :isAvailable where c.id = :id")
    @Transactional
    public void updateIsAvailable(@Param("id") Long id, @Param("isAvailable") Boolean isAvailable);
    public List<Car> findCarByBrandAndModel(String brand, String model);

    public List<Car> findCarByPartnerId(Long partnerId);
}
