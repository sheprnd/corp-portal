package ru.usetech.qa.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.usetech.qa.model.DepartmentData;
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
        app.users().create(new UserData().withLastName("#auto LastName").withFirstName("#auto FirstName")
                .withEmail(new Random().nextInt(10000) + "@yandex.ru").withPassword("1")); //доделать рандомное получение данных юзера
        app.users().alertSuccess();
    }

    @Test
    public void testRoleCreation() {


        app.settings().goToRoles();
        app.roles().create(new RoleData().withRoleName("#auto Role" + UUID.randomUUID().toString()));
        app.roles().alertSuccess();
    }

    @Test
    public void testDepartmentCreation() {
        app.settings().goToDepartments();
        app.departmentsPage().create(new DepartmentData().withDepartmentName("#auto Department name " + UUID.randomUUID().toString()));
    }
}
