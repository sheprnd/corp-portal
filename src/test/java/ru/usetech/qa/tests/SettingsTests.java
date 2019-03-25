package ru.usetech.qa.tests;


import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.usetech.qa.model.*;

import java.util.Random;
import java.util.UUID;

import static org.testng.Assert.assertEquals;
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
        assertEquals(actualCount, count+1);
    }

    @Test(priority=2)
    public void testRoleCreation() {

        app.settings().goToRoles();
        int count = app.roles().count();
        app.role().create(new RoleData().withName("#auto Role" + UUID.randomUUID().toString()));
        assertTrue(app.role().alertSuccess());
        int actualCount = app.roles().count();
        assertEquals(actualCount, count+1);
    }

    @Test(priority=3)
    public void testDepartmentCreation() {

        app.settings().goToDepartments();
        //исходное количество
        int count = app.list().elementsCount();
        app.department().create(new DepartmentData().withName("#auto Department " + UUID.randomUUID().toString()));
        assertTrue(app.department().alertSuccess());
        //новое количество
        int actualCount = app.list().elementsCount();
        assertEquals(actualCount, count+1);
    }

    @Test(priority=4)
    public void testFeedbackTemplateCreation() {

        app.settings().goToFeedbacktemplates();
        int count = app.list().elementsCount();
        app.feedbackTemplates().create(new FeedbackTemplateData()
                .withName("#auto Feedback " + UUID.randomUUID().toString())
                .withText("Прошу оценить результат:\n" + "{close_reasons}")
                .withReasonText("Отлично"));
        assertTrue(app.feedbackTemplates().alertSuccess());
        int actualCount = app.list().elementsCount();
        assertEquals(actualCount, count+1);

    }

    @Test(priority=5)
    public void testPriorityCreation() {

        app.settings().goToPriorities();
        int count = app.list().elementsCount();
        app.priority().create(new PriorityData().withName("#auto Priority " + UUID.randomUUID().toString()));
        assertTrue(app.priority().alertSuccess());
        int actualCount = app.list().elementsCount();
        assertEquals(actualCount, count+1);
    }

    @Test(priority=6)
    public void testCategoryCreation() {

        app.settings().goToCategories();
        int count = app.list().elementsCount();
        app.category().create(new CategoryData().withName("#auto Category " + UUID.randomUUID().toString()));
        assertTrue(app.category().alertSuccess());
        int actualCount = app.list().elementsCount();
        assertEquals(actualCount, count+1);
    }

    @Test(priority=7)
    public void testReportCreation() {

        app.settings().goToReports();
        int count = app.list().elementsCount();
        app.report().create(new ReportData().
                withName("#auto Report " + UUID.randomUUID().toString()).
                withExternalId(new Random().nextInt(10000)));
        assertTrue(app.report().alertSuccess());
        int actualCount = app.list().elementsCount();
        assertEquals(actualCount, count+1);
    }

    @Test(priority=8)
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

    @Test(priority=9)
    public void testReportGroupCreation() {

        app.settings().goToReportGroups();
        int count = app.reportGroups().count();
        app.reportGroup().create(new ReportGroupData().withName("#auto ReportGroup " + UUID.randomUUID().toString()));
        assertTrue(app.reportGroup().alertSuccess());
        int actualCount = app.reportGroups().count();
        assertEquals(actualCount, count+1);
    }

}
