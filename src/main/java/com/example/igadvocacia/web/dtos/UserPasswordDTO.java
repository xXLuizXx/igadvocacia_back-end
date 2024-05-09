package com.example.igadvocacia.web.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserPasswordDTO {
    @NotBlank(message = "É obrigatório inserir uma senha!")
    @Size(min = 6, max = 8, message = "A senha deve conter no minimo 6 e máximo 8 caracteres!")
    private String passwordUser;
    @NotBlank(message = "É obrigatório inserir uma nova senha!")
    @Size(min = 6, max = 8, message = "A senha deve conter no minimo 6 e máximo 8 caracteres!")
    private String newPasswordUser;
    @NotBlank(message = "É obrigatório inserir a confirmação de senha!")
    @Size(min = 6, max = 8, message = "A senha deve conter no minimo 6 e máximo 8 caracteres!")
    private String confirmPasswordUser;

}
