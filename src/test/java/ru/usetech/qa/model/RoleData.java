package ru.usetech.qa.model;

import java.util.Objects;

public class RoleData {

    private String roleName;


    public String getRoleName() {
        return roleName;
    }


    public RoleData withName(String roleName) {
        this.roleName = roleName;
        return this;
    }

    @Override
    public String toString() {
        return "RoleData{" +
                "roleName='" + roleName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoleData roleData = (RoleData) o;
        return Objects.equals(roleName, roleData.roleName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleName);
    }
}
