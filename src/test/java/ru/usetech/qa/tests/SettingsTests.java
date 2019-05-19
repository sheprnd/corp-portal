package ru.usetech.qa.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.usetech.qa.model.*;

import java.util.HashSet;
import java.util.List;
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
        List<UserData> before = app.users().getList();
        UserData newUser = new UserData().withLastName("#auto LastName" + new Random().nextInt(100000))
                .withFirstName("#auto FirstName" + new Random().nextInt(100000))
                .withEmail(System.currentTimeMillis() + "@yandex.ru")
                .withPassword("1");
        app.user().create(newUser);
        assertTrue(app.user().alertSuccess(), "Не появился алерт об успешном создании пользователя.");
        app.users().waitListUpdated(count, 2);
        int actualCount = app.users().count();
        assertEquals(actualCount, count+1, "После создания нового пользователя количество пользователей в списке не увеличилось на 1.");
        before.add(newUser);
        List<UserData> after = app.users().getList();
        assertEquals(new HashSet<>(after), new HashSet<>(before),  "Отличаются ожидаемый и полученный список пользователей после добавления нового пользователя.");
    }

    @Test(priority=2)
    public void testUserEditing() {

        app.settings().goToUsers();
        app.users().waitListUpdated(0,2);
        // редактируем первого юзера
        int index = 1;
        // получаем данные юзера из списка
        // (в данных юзера - email, чтобы после обновления найти по нему строку,
        // так как после обновления строка меняет положение в списке)
        UserData user = app.users().getUserByIndex(index);
        // данные для обновления юзера
        UserData updUser = new UserData().withFirstName("#auto FirstName_upd " + new Random().nextInt(100000))
                .withLastName("#auto LastName_upd " + new Random().nextInt(100000));

        String expectedFullName = app.user().getFullName(updUser);
        app.user().edit(index, updUser);
        assertTrue(app.user().alertSuccess(), "Не появился алерт об успешном обновлении пользователя.");
        String actualFullName = app.users().getUserFullNameByEmail(user.getEmail());
        assertEquals(actualFullName, expectedFullName, "В списке пользователей не отображается обновленное имя пользователя");
    }

    @Test(priority=3)
    public void testUserDeletion() {

        app.settings().goToUsers();
        // так как для логина и для апи используются пользователи
        // создадим отдельного пользователя, которого будем удалять
        int count = app.users().count();
        List<UserData> before = app.users().getList();
        UserData user = new UserData().withLastName("#auto LastName" + new Random().nextInt(100000))
                .withFirstName("#auto FirstName" + new Random().nextInt(100000))
                .withEmail(System.currentTimeMillis() + "@yandex.ru")
                .withPassword("1");
        app.user().create(user);
        assertTrue(app.user().alertSuccess(), "Не появился алерт об успешном создании пользователя.");
        app.users().waitListUpdated(count, 2);
        // удаляем созданного пользователя
        app.users().delete(user);
        app.confirmDialog().confirm();
        app.users().waitListUpdated(count+1, 1);
        int actualCount = app.users().count();
        assertEquals(actualCount, count, "После удаления пользователя количество пользоватей в списке не уменьшилось на 1.");
        List<UserData> after = app.users().getList();
        assertEquals(new HashSet<>(after), new HashSet<>(before),  "Отличаются ожидаемый и полученный список пользователей после удаления пользователя.");
    }

    @Test(priority=4)
    public void testDepartmentCreation() throws Exception{

        app.settings().goToDepartments();
        //исходное количество
        int count = 0;
        if (app.settingsHelper().getActiveDepartmentsCount() != 0)
            count = app.departments().count();
        // исходный список отделов
        List<DepartmentData> before = app.departments().getList();
        // создаем новый отдел
        DepartmentData newDepartment = new DepartmentData().withName("#auto Department " + System.currentTimeMillis());
        app.department().create(newDepartment);
        assertTrue(app.department().alertSuccess(), "Не появился алерт об успешном создании отдела.");
        app.departments().waitListUpdated(count,2);
        //новое количество
        int actualCount = app.departments().count();
        assertEquals(actualCount, count+1, "После создания нового отдела количество отделов в списке не увеличилось на 1.");
        // ожидаемый список отделов
        before.add(newDepartment);
        // текущий список отделов
        List<DepartmentData> after = app.departments().getList();
        assertEquals(new HashSet<>(after), new HashSet<>(before),  "Отличаются ожидаемый и полученный список отделов после добавления нового отдела.");
    }

    @Test(priority=5)
    public void testDepartmentEditing() throws Exception{

        app.settings().goToDepartments();
        // если список отделов пустой - создаем новый отдел
        if (app.settingsHelper().getActiveDepartmentsCount() == 0) {
            app.department().create(new DepartmentData().withName("#auto Department " + System.currentTimeMillis()));
        }
        app.departments().waitListUpdated(0,2);
        // исходный список отделов
        List<DepartmentData> before = app.departments().getList();
        // редактируем первый отдел
        int index = 1;
        DepartmentData updDepartment = new DepartmentData().withName("#auto Department " + System.currentTimeMillis());
        app.department().edit(index, updDepartment);
        assertTrue(app.department().alertSuccess(), "Не появился алерт об успешном обновлении отдела.");
        // формируем ожидаемый список
        before.remove(index - 1);
        before.add(updDepartment);
        // обновленный список отделов
        List<DepartmentData> after = app.departments().getList();
        // сравнение списков, преобразованных в неупорядочееное множество,
        // т.к. после редактирования отдел меняет положение в списке
        assertEquals(new HashSet<>(after), new HashSet<>(before),  "В списке отделов не отображается обновленное имя отдела");

    }

    @Test(priority=6)
    public void testDepartmentDeletion() throws Exception {

        app.settings().goToDepartments();
        // если список отделов пустой - создаем новый, который будем далее удалять
        if (app.settingsHelper().getActiveDepartmentsCount() == 0){
            app.department().create(new DepartmentData().withName("#auto Department " + System.currentTimeMillis()));
            app.departments().waitListUpdated(0,2);
        }
        int count = app.departments().count();
        List<DepartmentData> before = app.departments().getList();
        // удаляем первый отдел
        int index = 1;
        app.departments().delete(index);
        app.confirmDialog().confirm();
        app.departments().waitListUpdated(count, 1);
        int actualCount = app.departments().count();
        assertEquals(actualCount, count-1, "После удаления отдела количество отделов в списке не уменьшилось на 1.");
        before.remove(index - 1);
        // обновленный список отделов
        List<DepartmentData> after = app.departments().getList();
        assertEquals(new HashSet<>(after), new HashSet<>(before),  "Отличаются ожидаемый и полученный список отделов после удаления отдела.");

    }

    @Test(priority=7)
    public void testRoleCreation() {

        app.settings().goToRoles();
        int count = app.roles().count();
        List<RoleData> before = app.roles().getList();
        RoleData newRole = new RoleData().withName("#auto Role" + + System.currentTimeMillis());
        app.role().create(newRole);
        assertTrue(app.role().alertSuccess(), "Не появился алерт об успешном создании роли.");
        app.roles().waitListUpdated(count, 2);
        int actualCount = app.roles().count();
        assertEquals(actualCount, count+1, "После создания новой роли количество ролей в списке не увеличилось на 1.");
        before.add(newRole);
        List<RoleData> after = app.roles().getList();
        assertEquals(new HashSet<>(after), new HashSet<>(before),  "Отличаются ожидаемый и полученный список ролей после добавления новой роли.");
    }

    @Test(priority=8)
    public void testRoleEditing() {

        app.settings().goToRoles();
        app.roles().waitListUpdated(0,2);
        List<RoleData> before = app.roles().getList();
        int index = 1;
        RoleData updRole = new RoleData().withName("#auto Role" + System.currentTimeMillis());
        app.role().edit(index, updRole);
        assertTrue(app.role().alertSuccess(), "Не появился алерт об успешном обновлении роли.");
        before.remove(index - 1);
        before.add(updRole);
        List<RoleData> after = app.roles().getList();
        assertEquals(new HashSet<>(after), new HashSet<>(before),  "В списке ролей не отображается обновленное имя роли");
    }

    @Test(priority=9)
    public void testRoleDeletion() {

        app.settings().goToRoles();
        // так как для логина и для апи используются пользователи c ролями
        // создадим отдельную роль, которую будем удалять
        int count = app.roles().count();
        List<RoleData> before = app.roles().getList();
        RoleData role = new RoleData().withName("#auto Role" + + System.currentTimeMillis());
        app.role().create(role);
        assertTrue(app.role().alertSuccess(), "Не появился алерт об успешном создании роли.");
        app.roles().waitListUpdated(count, 2);
        // удаляем созданную роль
        app.roles().delete(role);
        app.confirmDialog().confirm();
        app.roles().waitListUpdated(count + 1, 1);
        int actualCount = app.roles().count();
        assertEquals(actualCount, count, "После удаления роли количество ролей в списке не уменьшилось на 1.");
        List<RoleData> after = app.roles().getList();
        assertEquals(new HashSet<>(after), new HashSet<>(before),  "Отличаются ожидаемый и полученный список ролей после удаления роли.");
    }

    @Test(priority=10)
    public void testDefaultTimesheetEditing() {

        // сейчас реализован только выбор целых часов
        int timeAt = 13;
        int timeTo = 21;
        String expectedValue = "13:00 — 20:59";

        app.settings().goToTimesheets();
        app.timesheets().waitListUpdated(0, 2);

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

    @Test(priority=11)
    public void testUserTimesheetCreation() {

        // создадим нового юзера, которого будем выбирать в расписании
        app.settings().goToUsers();
        UserData user = new UserData().withLastName("#auto LastName" + new Random().nextInt(100000))
                .withFirstName("#auto FirstName" + new Random().nextInt(100000))
                .withEmail(System.currentTimeMillis() + "@yandex.ru")
                .withPassword("1");
        app.user().create(user);

        app.settings().goToTimesheets();
        int count = app.timesheets().count();
        List<TimesheetData> before = app.timesheets().getList();
        app.timesheet().create(user);
        assertTrue(app.timesheet().alertSuccess(), "Не появился аллерт об успешном создании расписания пользователя");
        app.timesheets().waitListUpdated(count, 2);
        int actualCount = app.timesheets().count();
        assertEquals(actualCount, count+1, "После создания нового расписания количество распианий в списке не увеличилось на 1.");
        before.add(new TimesheetData().withUserFullName(user.getFullName()));
        List<TimesheetData> after = app.timesheets().getList();
        assertEquals(new HashSet<>(after), new HashSet<>(before),  "Отличаются ожидаемый и полученный список расписаний после добавления нового расписания.");

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
        app.list().waitListUpdated(count, 2);

        int actualCount = app.list().elementsCount();
        assertEquals(actualCount, count+1);

    }



    @Test(priority=7)
    public void testWebhookCreation() {

        app.settings().goToWebhooks();
        int count = app.webhooks().count();
        app.webhook().create(new WebhookData().
                withName("#auto Webhook" + new Random().nextInt(100000)).
                withUrl("https://mlgext.usetech.ru/"));
        assertTrue(app.webhook().alertSuccess());
        app.webhooks().waitListUpdated(count, 2);
        int actualCount = app.webhooks().count();
        assertEquals(actualCount, count+1);
    }

    @Test(priority=8)
    public void testPostRuleCreation() {

        app.settings().goToRules();
        int count = app.postRules().count();
        app.postRule().create(new PostRuleData().withContext("#auto PostRule" + new Random().nextInt(100000)));
        assertTrue(app.postRule().alertSuccess());
        app.postRules().waitListUpdated(count, 2);
        int actualCount = app.postRules().count();
        assertEquals(actualCount, count+1);
    }

    @Test(priority=9)
    public void testIncidentRuleCreation() {

        app.settings().goToRules();
        int count = app.incidentRules().count();
        app.incidentRule().create();
        assertTrue(app.incidentRule().alertSuccess());
        app.incidentRules().waitListUpdated(count, 2);
        int actualCount = app.incidentRules().count();
        assertEquals(actualCount, count+1);
    }

    @Test(priority=10)
    public void testPriorityCreation() {

        app.settings().goToPriorities();
        int count = app.list().elementsCount();
        app.priority().create(new PriorityData().withName("#auto Priority " + new Random().nextInt(100000)));
        assertTrue(app.priority().alertSuccess());
        app.list().waitListUpdated(count, 2);
        int actualCount = app.list().elementsCount();
        assertEquals(actualCount, count+1);
    }

    @Test(priority=11)
    public void testCategoryCreation() {

        app.settings().goToCategories();
        int count = app.list().elementsCount();
        app.category().create(new CategoryData().withName("#auto Category " + new Random().nextInt(100000)));
        assertTrue(app.category().alertSuccess());
        app.list().waitListUpdated(count, 2);
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
        app.list().waitListUpdated(count, 2);
        int actualCount = app.list().elementsCount();
        assertEquals(actualCount, count+1);
    }

    @Test(priority=13)
    public void testReportGroupCreation() {

        app.settings().goToReportGroups();
        int count = app.reportGroups().count();
        app.reportGroup().create(new ReportGroupData().withName("#auto ReportGroup " + new Random().nextInt(100000)));
        assertTrue(app.reportGroup().alertSuccess());
        app.reportGroups().waitListUpdated(count, 2);
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
        app.list().waitListUpdated(count, 2);
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
