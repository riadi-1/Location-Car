package com.rentacarhub.rentacarhub.dto;

import com.rentacarhub.rentacarhub.entity.Admin;
import com.rentacarhub.rentacarhub.entity.Partner;
import com.rentacarhub.rentacarhub.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginDto {
    private String email;
    private String username;
    private String password;




    public static LoginDto userLoginDto(User user){
        LoginDto loginDto = new LoginDto();
        loginDto.setEmail(user.getEmail());
        loginDto.setPassword(user.getPassword());
        loginDto.setUsername(user.getUserName());

        return loginDto;
    }



    public static LoginDto adminLoginDto(Admin admin){
        LoginDto loginDto = new LoginDto();
        loginDto.setEmail(admin.getEmail());
        loginDto.setPassword(admin.getPassword());
        loginDto.setUsername(admin.getUserName());

        return loginDto;
    }

    public static LoginDto partnerLoginDto(Partner partner){
        LoginDto loginDto = new LoginDto();
        loginDto.setEmail(partner.getEmail());
        loginDto.setPassword(partner.getPassword());
//        loginDto.setUsername(partner.getUserName());
        loginDto.setUsername(null);
        return loginDto;
    }


}
