package com.rentacarhub.rentacarhub.dto;

import com.rentacarhub.rentacarhub.entity.Admin;
import com.rentacarhub.rentacarhub.entity.Car;
import com.rentacarhub.rentacarhub.entity.Reservation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String phone;
    private String email;
    public static Admin getAdmin(AdminDto adminDto){
        Admin admin = new Admin();
        BeanUtils.copyProperties(adminDto,admin);
        return admin;
    }

    public static AdminDto getAdminDto(Admin admin){
        AdminDto adminDto = new AdminDto();
        BeanUtils.copyProperties(admin,adminDto);
        return adminDto;
    }


}
