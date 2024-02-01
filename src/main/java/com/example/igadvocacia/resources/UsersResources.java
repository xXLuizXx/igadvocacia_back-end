package com.example.igadvocacia.resources;

import com.example.igadvocacia.entities.Users;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UsersResources {

    @GetMapping
    public ResponseEntity<Users> findAll(){
        Users user = new Users(1L, "Isabella", "Gomes Fonseca", "Advogada", "isabellagfonseca@gmail.com", "12345", "isabella.gomes", true);
        return ResponseEntity.ok().body(user);
    }

}
