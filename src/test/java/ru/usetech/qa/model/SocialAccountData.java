package ru.usetech.qa.model;

public class SocialAccountData {

    private String username;
    private String password;
    // флаг, что аккаунт с группами
    private boolean withGroups;
    // массив групп
    private String[] groups;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean isWithGroups() {return withGroups;}

    public String[] getGroups() {return groups;}

    public SocialAccountData withUsername(String username) {

        this.username = username;
        return this;

    }

    public SocialAccountData withPassword(String password) {

        this.password = password;
        return this;

    }

    public SocialAccountData withGroups(String[] groups)
    {
        this.withGroups = true;
        this.groups = groups;
        return this;
    }


}
