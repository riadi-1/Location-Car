package com.rentacarhub.rentacarhub.repository;

import com.rentacarhub.rentacarhub.entity.Car;
import com.rentacarhub.rentacarhub.entity.RentalHistory;
import com.rentacarhub.rentacarhub.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RentalHistoryRepository extends JpaRepository<RentalHistory,Long> {

    List<RentalHistory> findRentalHistoriesByUser(User user);
    @Query(value = "select sum(rentPerDay) from RentalHistory ")
    public Long totalRent();
}
