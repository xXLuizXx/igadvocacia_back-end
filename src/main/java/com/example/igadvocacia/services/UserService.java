package com.example.igadvocacia.services;

import com.example.igadvocacia.entities.User;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.igadvocacia.repositories.UserRespository;
import org.springframework.stereotype.Service;


import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {

    @Autowired
    private final UserRespository userRespository;

    @Transactional
    public User saveUser(User user) {
        return userRespository.save(user);
    }

    @Transactional(readOnly = true)
    public User buscarId(Long id) {
        return userRespository.findById(id).orElseThrow(
                () -> new RuntimeException("Usuário não encontrado.")
        );
    }

    @Transactional
    public User editarSenha(Long id, String passwordUser, String newPasswordUser, String confirmPasswordUser) {

        if(!newPasswordUser.equals(confirmPasswordUser)){
            throw new RuntimeException("Nova senha não confere com a senha de confirmação, favor verificar.");
        }

        User user = buscarId(id);

        if(!user.getPasswordUser().equals(passwordUser)){
            throw new RuntimeException("Senha incorreta.");
        }
        user.setPasswordUser(passwordUser);

        return user;
    }
    @Transactional(readOnly = true)
    public List<User> buscarTodos() {
        return userRespository.findAll();
    }
}
