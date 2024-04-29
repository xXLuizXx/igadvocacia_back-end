package com.example.igadvocacia.web.dtos;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserPasswordDTO {
    private String passwordUser;
    private String newPasswordUser;
    private String confirmPasswordUser;

}
