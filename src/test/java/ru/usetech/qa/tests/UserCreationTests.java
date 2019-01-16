package ru.usetech.qa.tests;

import org.testng.annotations.Test;
import ru.usetech.qa.model.UserData;


import java.util.Date;

import static org.testng.Assert.assertTrue;

public class UserCreationTests extends TestBase{

    @Test
    public void testUserCreation() {

        app.login();
        app.goToUsersList();
        int usersCount = app.usersCount();
        app.addNewUser(new UserData("тест_Фамилия", "тест_Имя", new Date().toString()+"@yandex.ru","pass"));
        int actualUsersCount = app.usersCount();

        assertTrue(actualUsersCount == usersCount + 1, "-");
    }
}
