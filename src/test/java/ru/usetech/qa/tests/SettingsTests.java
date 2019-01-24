package ru.usetech.qa.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.usetech.qa.model.UserData;

import java.util.Random;

import static org.testng.Assert.assertEquals;

public class SettingsTests extends TestBase{

    @BeforeClass
    public void ensurePreconditions(){

        app.goTo().settings();

    }

    @Test
    public void testUserCreation() {

        app.settings().goToUsers();
        
        int before = app.users().list();
        app.users().create(new UserData().withLastName("#auto LastName").withFirstName("#auto FirstName")
                .withEmail(new Random().nextInt(10000) + "@yandex.ru").withPassword("1")); //доделать рандомное получение данных юзера

        int after = app.users().list();

        assertEquals(after , before + 1);
    }
}
