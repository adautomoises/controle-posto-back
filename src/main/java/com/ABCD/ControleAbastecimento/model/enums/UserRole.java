package com.ABCD.ControleAbastecimento.model.enums;

public enum UserRole {
    MANAGER ("manager"),
    ATTENDANT ("attendant");

    private String role;

    UserRole(String role){
        this.role = role;
    }

    public String getRole(){
        return role;
    }
}
