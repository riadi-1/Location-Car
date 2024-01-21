package com.rentacarhub.rentacarhub.repository;

import com.rentacarhub.rentacarhub.entity.CreditCard;
import com.rentacarhub.rentacarhub.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User,Long> {

    public User getUserByEmail(String email);

}
