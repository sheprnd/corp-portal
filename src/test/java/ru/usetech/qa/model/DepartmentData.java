package ru.usetech.qa.model;

import java.util.Objects;

public class DepartmentData {

    private String departmentName;


    public String getDepartmentName() {
        return departmentName;
    }


    public DepartmentData withName(String departmentName) {

        this.departmentName = departmentName;
        return this;

    }

    @Override
    public String toString() {
        return "DepartmentData{" +
                "departmentName='" + departmentName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DepartmentData that = (DepartmentData) o;
        return Objects.equals(departmentName, that.departmentName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(departmentName);
    }
}
