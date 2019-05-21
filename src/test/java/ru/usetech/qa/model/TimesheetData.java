package ru.usetech.qa.model;

import java.util.Objects;

public class TimesheetData {

    private String userFullName;

    public TimesheetData withUserFullName(String userFullName) {
        this.userFullName = userFullName;
        return this;
    }

    @Override
    public String toString() {
        return "TimesheetData{" +
                "userFullName='" + userFullName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TimesheetData that = (TimesheetData) o;
        return Objects.equals(userFullName, that.userFullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userFullName);
    }
}
