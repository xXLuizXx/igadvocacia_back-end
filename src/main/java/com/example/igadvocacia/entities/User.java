package com.example.igadvocacia.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;


@Getter @Setter @NoArgsConstructor
@Entity
@Table(name = "users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUser")
    private Long idUser;
    @Column(name = "nameUser", nullable = false, length = 25)
    private String nameUser;
    @Column(name = "sobrenomeUser", nullable = false, length = 100)
    private String sobrenomeUser;
    @Column(name = "emailUser", nullable = false, unique = true, length = 100)
    private String emailUser;
    @Column(name = "passwordUser", nullable = false)
    private String passwordUser;
    @Column(name = "avatarUser")
    private String avatarUser;
    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private Role role = Role.ROLE_ADV;
    @Column(name = "dataCriacao")
    private LocalDateTime dataCriacao;
    @Column(name = "dataModificacao")
    private LocalDateTime dataModificacao;
    @Column(name = "criadoPor")
    private String criadoPor;
    @Column(name = "alteradoPor")
    private String alteradoPor;
    public enum Role{
        ROLE_ADMIN, ROLE_ADV, ROLE_SEC
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return Objects.equals(getIdUser(), user.getIdUser());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdUser());
    }

    @Override
    public String toString() {
        return "User{" +
                "idUser=" + idUser +
                '}';
    }
}
