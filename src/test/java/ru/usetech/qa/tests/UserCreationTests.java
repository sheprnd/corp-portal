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
        System.out.println("ensurePreconditions");
    }

    @Test
    public void testUserCreation() {

        int before = app.users().list();
        app.users().create(new UserData().withLastName("тест_Фамилия").withFirstName("тест_Имя")
                .withEmail("11111111111111@yandex.ru").withPassword("1")); //доделать рандомное получение данных юзера
        int after = app.users().list();

        assertEquals(before , after + 1);
    }
}
