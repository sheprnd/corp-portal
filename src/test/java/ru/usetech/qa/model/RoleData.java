package ru.usetech.qa.model;

public class RoleData {

    private String roleName;


    public String getRoleName() {
        return roleName;
    }


    public RoleData withName(String roleName) {
        this.roleName = roleName;
        return this;
    }


}
