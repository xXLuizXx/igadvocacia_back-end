package com.example.igadvocacia.web.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserCreateDTO {
    @NotBlank(message = "É obrigatório inserir o primeiro nome!")
    private String nameUser;
    @NotBlank(message = "É obrigatório inserir o segundo nome!")
    private String sobrenomeUser;
    @NotBlank(message = "É obrigatório inserir um e-mail!")
    @Email(regexp = "^[a-z0-9._-]+@[a-z0-9]+\\.[a-z]+\\.([a-z]+)?$/i", message = "Formato de e-mail invalido!")
    private String emailUser;
    @NotBlank(message = "É obrigatório inserir uma senha!")
    @Size(min = 6, max = 8, message = "A senha deve conter no minimo 6 e máximo 8 caracteres!")
    private String passwordUser;
    private String avatarUser;
}
