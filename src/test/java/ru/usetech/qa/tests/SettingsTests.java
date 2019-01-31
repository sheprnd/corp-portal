package ru.usetech.qa.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.usetech.qa.model.RoleData;
import ru.usetech.qa.model.UserData;

import java.util.Random;
import java.util.UUID;

public class SettingsTests extends TestBase {

    @BeforeTest
    public void ensurePreconditions() {

        app.goTo().settings();

    }

    @Test
    public void testUserCreation() {


        app.settings().goToUsers();

        //int before = app.users().list();
        app.users().create(new UserData().withLastName("#auto LastName").withFirstName("#auto FirstName")
                .withEmail(new Random().nextInt(10000) + "@yandex.ru").withPassword("1")); //доделать рандомное получение данных юзера

        /*int after = app.users().list();


        assertEquals(after, before + 1);*/
        app.users().alertSuccess();
    }

    @Test
    public void testRoleCreation() {


        app.settings().goToRoles();

        //int before = app.roles().list();
        app.roles().create(new RoleData().withRoleName("#auto Role" + UUID.randomUUID().toString()));

        /*int after = app.roles().list();
        assertEquals(after, before + 1);*/

        app.roles().alertSuccess();
    }
}
