package ru.usetech.qa.tests;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.usetech.qa.model.*;

import java.util.Random;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class SettingsTests extends TestBase {

    @BeforeClass
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
    public void testDepartmentCreation() {

        app.settings().goToDepartments();
        //исходное количество
        int count = app.list().elementsCount();
        app.department().create(new DepartmentData().withName("#auto Department " + new Random().nextInt(100000)));
        assertTrue(app.department().alertSuccess());
        //новое количество
        int actualCount = app.list().elementsCount();
        assertEquals(actualCount, count+1);
    }

    @Test(priority=3)
    public void testRoleCreation() {

        app.settings().goToRoles();
        int count = app.roles().count();
        app.role().create(new RoleData().withName("#auto Role" + new Random().nextInt(100000)));
        assertTrue(app.role().alertSuccess());
        int actualCount = app.roles().count();
        assertEquals(actualCount, count+1);
    }

    @Test(priority=4)
    public void testTimesheetCreation() {

        app.settings().goToTimesheets();
        int count = app.timesheets().count();
        System.out.println(count);
        app.timesheet().create();
        assertTrue(app.timesheet().alertSuccess());
        int actualCount = app.timesheets().count();
        System.out.println(actualCount);
        assertEquals(actualCount, count+1);
    }

    @Test(priority=5)
    public void testFeedbackTemplateCreation() {

        app.settings().goToFeedbacktemplates();
        int count = app.list().elementsCount();
        app.feedbackTemplates().create(new FeedbackTemplateData()
                .withName("#auto Feedback " + new Random().nextInt(100000))
                .withText("Прошу оценить результат:\n" + "{close_reasons}")
                .withReasonText("Отлично"));
        assertTrue(app.feedbackTemplates().alertSuccess());

        int actualCount = app.list().elementsCount();
        assertEquals(actualCount, count+1);

    }

    @Test(priority=6)
    public void testPriorityCreation() {

        app.settings().goToPriorities();
        int count = app.list().elementsCount();
        app.priority().create(new PriorityData().withName("#auto Priority " + new Random().nextInt(100000)));
        assertTrue(app.priority().alertSuccess());
        int actualCount = app.list().elementsCount();
        assertEquals(actualCount, count+1);
    }

    @Test(priority=7)
    public void testCategoryCreation() {

        app.settings().goToCategories();
        int count = app.list().elementsCount();
        app.category().create(new CategoryData().withName("#auto Category " + new Random().nextInt(100000)));
        assertTrue(app.category().alertSuccess());
        int actualCount = app.list().elementsCount();
        assertEquals(actualCount, count+1);
    }

    @Test(priority=8)
    public void testReportCreation() {

        app.settings().goToReports();
        int count = app.list().elementsCount();
        app.report().create(new ReportData().
                withName("#auto Report " + new Random().nextInt(100000)).
                withExternalId(new Random().nextInt(100000)));
        assertTrue(app.report().alertSuccess());
        int actualCount = app.list().elementsCount();
        assertEquals(actualCount, count+1);
    }

    @Test(priority=9)
    public void testReportGroupCreation() {

        app.settings().goToReportGroups();
        int count = app.reportGroups().count();
        app.reportGroup().create(new ReportGroupData().withName("#auto ReportGroup " + new Random().nextInt(100000)));
        assertTrue(app.reportGroup().alertSuccess());
        int actualCount = app.reportGroups().count();
        assertEquals(actualCount, count+1);
    }

    @Test(priority=10)
    public void testLocationCreation() {

        app.settings().goToLocations();
        int count = app.list().elementsCount();
        app.location().create(new LocationData().
                withName("#auto Location " + new Random().nextInt(100000)));
        assertTrue(app.location().alertSuccess());
        int actualCount = app.list().elementsCount();
        assertEquals(actualCount, count+1);
    }

    @Test(priority=11)
    public void testClientReferenceCreationAndDeletionTest() throws Exception {

        String name = "#auto ClientReference " + new Random().nextInt(100000);

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
