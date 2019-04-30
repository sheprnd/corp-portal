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

    @Test(priority=1, invocationCount = 1)
    public void testUserCreation() {

        app.settings().goToUsers();
        int count = app.users().count();
        app.user().create(new UserData().withLastName("#auto LastName" + new Random().nextInt(100000)).withFirstName("#auto FirstName" + new Random().nextInt(100000))
                .withEmail(new Random().nextInt(10000) + "@yandex.ru").withPassword("1")); //доделать рандомное получение данных юзера
        assertTrue(app.user().alertSuccess());
        app.users().waitListUpdated(count);
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
        app.list().waitListUpdated(count);
        int actualCount = app.list().elementsCount();
        assertEquals(actualCount, count+1);
    }

    @Test(priority=3)
    public void testRoleCreation() {

        app.settings().goToRoles();
        int count = app.roles().count();
        app.role().create(new RoleData().withName("#auto Role" + new Random().nextInt(100000)));
        assertTrue(app.role().alertSuccess());
        app.roles().waitListUpdated(count);
        int actualCount = app.roles().count();
        assertEquals(actualCount, count+1);
    }

    @Test(priority=4, enabled = false, invocationCount = 1)
    public void testTimesheetCreation() {

        app.settings().goToTimesheets();
        int count = app.timesheets().count();
        app.timesheet().create();
        assertTrue(app.timesheet().alertSuccess());
        app.timesheets().waitListUpdated(count);
        int actualCount = app.timesheets().count();
        assertEquals(actualCount, count+1);
    }

    @Test(priority=5)
    public void testFeedbackTemplateCreation() {

        app.settings().goToFeedbacktemplates();
        int count = app.list().elementsCount();
        app.feedbackTemplate().create(new FeedbackTemplateData()
                .withName("#auto Feedback " + new Random().nextInt(100000))
                .withText("Прошу оценить результат:\n" + "{close_reasons}")
                .withReasonText("Отлично"));
        assertTrue(app.feedbackTemplate().alertSuccess());
        app.list().waitListUpdated(count);

        int actualCount = app.list().elementsCount();
        assertEquals(actualCount, count+1);

    }

    @Test(priority=6)
    public void testDefaultTimesheetEditing() {

        // сейчас реализован только выбор целых часов
        int timeAt = 13;
        int timeTo = 21;
        String expectedValue = "13:00 — 20:59";

        app.settings().goToTimesheets();
        app.timesheets().waitListUpdated(0);

        String value = app.timesheets().getValueFromTheCell(1);

        // если в ячейке указано время, то флаг дня будет сниматься
        // и время устанавливать не нужно
        if (!value.equals("-")) {
            timeAt = -1;
            timeTo = -1;
            expectedValue = "-";
        }

        app.timesheet().editDefaultTimesheet(1, timeAt, timeTo);
        assertTrue(app.timesheet().alertSuccess(), "Не появился аллерт об успешном обновлении общего расписания.");

        String actualValue = app.timesheets().getValueFromTheCell(1);
        assertEquals(actualValue, expectedValue, "Для общего расписания не верно отображается обновленное время в ячейке");

    }

    @Test(priority=7)
    public void testWebhookCreation() {

        app.settings().goToWebhooks();
        int count = app.webhooks().count();
        app.webhook().create(new WebhookData().
                withName("#auto Webhook" + new Random().nextInt(100000)).
                withUrl("https://mlgext.usetech.ru/"));
        assertTrue(app.webhook().alertSuccess());
        app.webhooks().waitListUpdated(count);
        int actualCount = app.webhooks().count();
        assertEquals(actualCount, count+1);
    }

    @Test(priority=8)
    public void testPostRuleCreation() {

        app.settings().goToRules();
        int count = app.postRules().count();
        app.postRule().create(new PostRuleData().withContext("#auto PostRule" + new Random().nextInt(100000)));
        assertTrue(app.postRule().alertSuccess());
        app.postRules().waitListUpdated(count);
        int actualCount = app.postRules().count();
        assertEquals(actualCount, count+1);
    }

    @Test(priority=9)
    public void testIncidentRuleCreation() {

        app.settings().goToRules();
        int count = app.incidentRules().count();
        app.incidentRule().create();
        assertTrue(app.incidentRule().alertSuccess());
        app.incidentRules().waitListUpdated(count);
        int actualCount = app.incidentRules().count();
        assertEquals(actualCount, count+1);
    }

    @Test(priority=10)
    public void testPriorityCreation() {

        app.settings().goToPriorities();
        int count = app.list().elementsCount();
        app.priority().create(new PriorityData().withName("#auto Priority " + new Random().nextInt(100000)));
        assertTrue(app.priority().alertSuccess());
        app.list().waitListUpdated(count);
        int actualCount = app.list().elementsCount();
        assertEquals(actualCount, count+1);
    }

    @Test(priority=11)
    public void testCategoryCreation() {

        app.settings().goToCategories();
        int count = app.list().elementsCount();
        app.category().create(new CategoryData().withName("#auto Category " + new Random().nextInt(100000)));
        assertTrue(app.category().alertSuccess());
        app.list().waitListUpdated(count);
        int actualCount = app.list().elementsCount();
        assertEquals(actualCount, count+1);
    }

    @Test(priority=12)
    public void testReportCreation() {

        app.settings().goToReports();
        int count = app.list().elementsCount();
        app.report().create(new ReportData().
                withName("#auto Report " + new Random().nextInt(100000)).
                withExternalId(new Random().nextInt(100000)));
        assertTrue(app.report().alertSuccess());
        app.list().waitListUpdated(count);
        int actualCount = app.list().elementsCount();
        assertEquals(actualCount, count+1);
    }

    @Test(priority=13)
    public void testReportGroupCreation() {

        app.settings().goToReportGroups();
        int count = app.reportGroups().count();
        app.reportGroup().create(new ReportGroupData().withName("#auto ReportGroup " + new Random().nextInt(100000)));
        assertTrue(app.reportGroup().alertSuccess());
        app.reportGroups().waitListUpdated(count);
        int actualCount = app.reportGroups().count();
        assertEquals(actualCount, count+1);
    }

    @Test(priority=14)
    public void testLocationCreation() {

        app.settings().goToLocations();
        int count = app.list().elementsCount();
        app.location().create(new LocationData().
                withName("#auto Location " + new Random().nextInt(100000)));
        assertTrue(app.location().alertSuccess());
        app.list().waitListUpdated(count);
        int actualCount = app.list().elementsCount();
        assertEquals(actualCount, count+1);
    }

    @Test(priority=15)
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

    @Test(priority=16)
    public void testVKSocialAccountCreation() {

        String socialType = "ВКонтакте";
        String accountName = "Anna Test";
        String[] groups = {"Group_225","Group_1"};

        app.settings().goToSocialAccounts();

        // если учетки уже привязана - удаляем
        if (app.socialAccounts().socialAccountExists(socialType, accountName)) {
            int count = app.socialAccounts().countAccounts();
            app.socialAccounts().deleteSocialAccount(socialType, accountName);
            app.socialAccounts().waitListUpdated(count, 1);
        }

        int countAccounts = app.socialAccounts().countAccounts();
        int countGroups = groups.length;

        app.vkAccount().create(new SocialAccountData()
                .withUsername("+79188995534")
                .withPassword("annadev1234")
                .withGroups(groups));
        assertTrue(app.vkAccount().success(), "Не появился диалог успешной привязки учетки ВК");
        app.socialAccounts().waitListUpdated(countAccounts, 2);

        // проверка на количество аккаунтов
        int actualCountAccounts = app.socialAccounts().countAccounts();
        assertEquals(actualCountAccounts, countAccounts+1);

        // проверка на количество групп
        int actualCountGroups =  app.socialAccounts().countCroups(socialType, accountName);
        assertEquals(actualCountGroups, countGroups);


    }






}
