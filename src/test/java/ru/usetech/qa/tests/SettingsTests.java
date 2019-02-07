package ru.usetech.qa.tests;


import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.usetech.qa.model.*;

import java.util.Random;
import java.util.UUID;

import static org.testng.Assert.assertTrue;


public class SettingsTests extends TestBase {

    @BeforeTest
    public void ensurePreconditions() {

        app.goTo().settings();

    }

    @Test(priority=1)
    public void testUserCreation() {


        app.settings().goToUsers();
        app.users().create(new UserData().withLastName("#auto LastName").withFirstName("#auto FirstName")
                .withEmail(new Random().nextInt(10000) + "@yandex.ru").withPassword("1")); //доделать рандомное получение данных юзера
        assertTrue(app.users().alertSuccess());

    }

    @Test(priority=2)
    public void testRoleCreation() {

        app.settings().goToRoles();
        app.roles().create(new RoleData().withName("#auto Role" + UUID.randomUUID().toString()));
        assertTrue(app.roles().alertSuccess());
    }

    @Test(priority=3)
    public void testDepartmentCreation() {

        app.settings().goToDepartments();
        app.departments().create(new DepartmentData().withName("#auto Department " + UUID.randomUUID().toString()));
        assertTrue(app.departments().alertSuccess());
    }

    @Test(priority=4)
    public void testFeedbackTemplateCreation() {

        app.settings().goToFeedbacktemplates();
        app.feedbackTemplates().create(new FeedbackTemplateData()
                .withName("#auto Feedback " + UUID.randomUUID().toString())
                .withText("Прошу оценить результат:\n" + "{close_reasons}")
                .withReasonText("Отлично"));
        assertTrue(app.feedbackTemplates().alertSuccess());

    }

    /*Нужно допилить получение именно появившегося значка карандаша,
    * Сейчас берется только если справочник первый*/

    @Test(priority=5)
    public void testClientReferenceCreationAndDeletionTest() throws InterruptedException {

        app.settings();
        app.clientReferences().create(new ClientReferenceData()
        .withName("01_Тестовый справочник Selenium"));
        assertTrue(app.clientReferences().alertSuccess());

        app.clientReferences().delete(new ClientReferenceData()
                .withName("01_Тестовый справочник Selenium"));
        assertTrue(app.clientReferences().alertSuccess());


    }

}
