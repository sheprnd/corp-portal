package ru.usetech.qa.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.usetech.qa.model.UserData;

import java.util.Random;

import static org.testng.Assert.assertEquals;

public class UserCreationTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().settings();
        app.settings().goToUsers();
    }

    @Test
    public void testUserCreation() {

        int before = app.users().list();
        app.users().create(new UserData().withLastName("#auto LastName").withFirstName("#auto FirstName")
                .withEmail(new Random().nextInt(10000) + "@yandex.ru").withPassword("1")); //доделать рандомное получение данных юзера

        int after = app.users().list();

        assertEquals(before , after + 1);
    }
}
