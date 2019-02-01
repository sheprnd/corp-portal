package ru.usetech.qa.model;

public class DepartmentData {

    private String departmentName;


    public String getDepartmentName() {
        return departmentName;
    }


    public DepartmentData withDepartmentName(String departmentName) {

        this.departmentName = departmentName;
        return this;

    }


}
