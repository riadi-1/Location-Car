package com.rentacarhub.rentacarhub.repository;

import com.rentacarhub.rentacarhub.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin,Long> {
//    public String getUserName();
        public Admin getAdminByEmail(String Email);


}
