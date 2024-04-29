package com.example.igadvocacia.web.dtos;

import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class UserResponseDTO {
    private Long idUser;
    private String role;
    private String nameUser;
    private String sobrenomeUser;
    private String emailUser;
    private String avatarUser;
}
