package com.example.igadvocacia.repositories;

import com.example.igadvocacia.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRespository extends JpaRepository<User, Long> {
}
