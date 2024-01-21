package com.rentacarhub.rentacarhub.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChangeUserPassword {
        private String oldPassword;
        private String newPassword;

}
