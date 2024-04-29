package com.example.igadvocacia.web.dtos;

import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class UserCreateDTO {

    private String nameUser;
    private String sobrenomeUser;
    private String emailUser;
    private String passwordUser;
    private String avatarUser;
}
