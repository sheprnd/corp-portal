package ru.usetech.qa.model;

public class UserData {

    private String lastName;
    private String firstName;
    private String email;
    private String password;

    /*public UserData(String lastName, String firstName, String email, String password) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.password = password;

    }*/

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
}
