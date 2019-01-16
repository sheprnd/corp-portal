package ru.usetech.qa.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Date;

import static org.testng.Assert.*;

public class SettingsTests extends TestBase{

    @Test
    public void createNewUser() {

        app.login();
        app.goToUsersList();
        int usersCount = app.usersCount();
        app.addNewUser("тест_Фамилия", "тест_Имя", new Date().toString()+"@yandex.ru","pass");
        int actualUsersCount = app.usersCount();

        assertTrue(actualUsersCount == usersCount + 1, "-");
    }

    /*@Test
    public void createNewRole() {

    }*/
}
