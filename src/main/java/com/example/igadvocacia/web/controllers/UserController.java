package com.example.igadvocacia.web.controllers;

import com.example.igadvocacia.entities.User;
import com.example.igadvocacia.services.UserService;
import com.example.igadvocacia.web.dtos.UserCreateDTO;
import com.example.igadvocacia.web.dtos.UserPasswordDTO;
import com.example.igadvocacia.web.dtos.UserResponseDTO;
import com.example.igadvocacia.web.dtos.mapper.UserMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/users")
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponseDTO> create(@Valid @RequestBody UserCreateDTO userCreateDTO){
        User criarUsuario = userService.saveUser(UserMapper.toUser(userCreateDTO));

        return ResponseEntity.status(HttpStatus.CREATED).body(UserMapper.toDTO(criarUsuario));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getById(@PathVariable Long id){
        User buscarUsuario= userService.buscarId(id);

        return ResponseEntity.ok().body(UserMapper.toDTO(buscarUsuario));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> updatePassword(@PathVariable Long id, @Valid @RequestBody UserPasswordDTO dto){
        User userUpdadePassword= userService.editarSenha(id, dto.getPasswordUser(), dto.getNewPasswordUser(), dto.getConfirmPasswordUser());

        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getAll(){
        List<User> users = userService.buscarTodos();

        return ResponseEntity.ok(UserMapper.toList(users));
    }
}
