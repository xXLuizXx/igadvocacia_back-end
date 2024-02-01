package com.example.igadvocacia.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_Users")
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;
    private String nameUser;
    private String sobrenomeUser;
    private String functionUser;
    private String emailUser;
    private String passwordUser;
    private String loginUser;
    private Boolean isAdmin;

    public Users(){

    }
    public Users(Long idUser, String nameUser, String sobrenomeUser, String functionUser, String emailUser, String passwordUser, String loginUser, Boolean isAdmin) {
        this.idUser = idUser;
        this.nameUser = nameUser;
        this.sobrenomeUser = sobrenomeUser;
        this.functionUser = functionUser;
        this.emailUser = emailUser;
        this.passwordUser = passwordUser;
        this.loginUser = loginUser;
        this.isAdmin = isAdmin;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getSobrenomeUser() {
        return sobrenomeUser;
    }

    public void setSobrenomeUser(String sobrenomeUser) {
        this.sobrenomeUser = sobrenomeUser;
    }

    public String getFunctionUser() {
        return functionUser;
    }

    public void setFunctionUser(String functionUser) {
        this.functionUser = functionUser;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    public String getPasswordUser() {
        return passwordUser;
    }

    public void setPasswordUser(String passwordUser) {
        this.passwordUser = passwordUser;
    }

    public String getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(String loginUser) {
        this.loginUser = loginUser;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Users users)) return false;
        return Objects.equals(getIdUser(), users.getIdUser()) && Objects.equals(getLoginUser(), users.getLoginUser());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdUser(), getLoginUser());
    }

}
