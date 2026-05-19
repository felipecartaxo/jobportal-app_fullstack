package com.cartaxo.jobportal.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "tb_user_types")
public class UserType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userTypeId;
    
    @NotBlank
    @NotEmpty
    private String userTypeName;

    @OneToMany(targetEntity = User.class, mappedBy = "userTypeId", cascade = CascadeType.ALL)
    private List<User> users;

    // ----- Construtores -----
    public UserType() {
    }

    public UserType(Long userTypeId, @NotBlank @NotEmpty String userTypeName, List<User> users) {
        this.userTypeId = userTypeId;
        this.userTypeName = userTypeName;
        this.users = users;
    }

    // ----- Getters e Setters -----
    public Long getUserTypeId() {
        return userTypeId;
    }

    public void setUserTypeId(Long userTypeId) {
        this.userTypeId = userTypeId;
    }

    public String getUserTypeName() {
        return userTypeName;
    }

    public void setUserTypeName(String userTypeName) {
        this.userTypeName = userTypeName;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    // ---- toString -----
    @Override
    public String toString() {
        return "UserType [userTypeId=" + userTypeId + ", userTypeName=" + userTypeName + "]";
    }
}