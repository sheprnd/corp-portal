package ru.usetech.qa.model;

import java.util.Objects;

public class UserData {

    private String lastName;
    private String firstName;
    private String email;
    private String password;

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public UserData withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public UserData withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public UserData withEmail(String email) {
        this.email = email;
        return this;
    }

    public UserData withPassword(String password) {
        this.password = password;
        return this;
    }

    @Override
    public String toString() {
        return "UserData{" +
                "email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserData userData = (UserData) o;
        return Objects.equals(email, userData.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }
}
