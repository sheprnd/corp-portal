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
        int count = app.users().count();
        app.user().create(new UserData().withLastName("#auto LastName").withFirstName("#auto FirstName")
                .withEmail(new Random().nextInt(10000) + "@yandex.ru").withPassword("1")); //доделать рандомное получение данных юзера
        assertTrue(app.user().alertSuccess());
        int actualCount = app.users().count();
        assertTrue(actualCount == count + 1, "-");
    }

    @Test(priority=2)
    public void testRoleCreation() {

        app.settings().goToRoles();
        int count = app.roles().count();
        app.role().create(new RoleData().withName("#auto Role" + UUID.randomUUID().toString()));
        assertTrue(app.role().alertSuccess());
        int actualCount = app.roles().count();
        assertTrue(actualCount == count + 1, "-");
    }

    @Test(priority=3)
    public void testDepartmentCreation() {

        app.settings().goToDepartments();
        //исходное количество
        int count = app.departments().count();
        app.department().create(new DepartmentData().withName("#auto Department " + UUID.randomUUID().toString()));
        assertTrue(app.department().alertSuccess());
        //новое количество
        int actualCount = app.departments().count();
        assertTrue(actualCount == count + 1, "-");
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


    @Test(priority=5)
    public void testClientReferenceCreationAndDeletionTest() throws Exception {

        String name = "#auto ClientReference " + new Random().nextInt(10000);

        app.clientReferences().create(new ClientReferenceData()
        .withName(name));
        assertTrue(app.clientReferences().alertSuccess());

        // определям индекс созданного справочника
        int index = app.settingsHelper().getClientReferenceIndex(name);

        if (index >= 0) {
            app.clientReferences().delete(index);
            assertTrue(app.clientReferences().alertSuccess());
        }



    }

}
