package ru.usetech.qa.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.usetech.qa.model.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
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

    /*@Test(priority=1, invocationCount = 1)
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
        app.user().closeAlert();
        app.users().waitListUpdated(count, 2);
        // удаляем созданного пользователя
        app.users().delete(user);
        app.confirmDialog().confirm();
        assertTrue(app.user().alertSuccess(), "Не появился алерт об успешном удалении пользователя.");
        app.users().waitListUpdated(count+1, 1);
        int actualCount = app.users().count();
        assertEquals(actualCount, count, "После удаления пользователя количество пользоватей в списке не уменьшилось на 1.");
        List<UserData> after = app.users().getList();
        assertEquals(new HashSet<>(after), new HashSet<>(before),  "Отличаются ожидаемый и полученный список пользователей после удаления пользователя.");
    }*/

    @Test(priority=4)
    public void testDepartmentCreation() throws Exception{

        app.settings().goToDepartments();
        //исходное количество
        int count = 0;
        if (app.settingsHelper().getActiveDepartmentsCount() != 0){
            app.departments().waitListUpdated(0,2);
            count = app.departments().count();
        }
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

   /* @Test(priority=5)
    public void testDepartmentEditing() throws Exception{

        app.settings().goToDepartments();
        // если список отделов пустой - создаем новый отдел
        if (app.settingsHelper().getActiveDepartmentsCount() == 0) {
            app.department().create(new DepartmentData().withName("#auto Department " + System.currentTimeMillis()));
            app.department().closeAlert();
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

    }*/

    @Test(priority=6)
    public void testDepartmentDeletion() throws Exception {

        app.settings().goToDepartments();
        // если список отделов пустой - создаем новый, который будем далее удалять
        if (app.settingsHelper().getActiveDepartmentsCount() == 0){
            app.department().create(new DepartmentData().withName("#auto Department " + System.currentTimeMillis()));
            app.department().closeAlert();
        }
        app.departments().waitListUpdated(0,2);
        int count = app.departments().count();
        List<DepartmentData> before = app.departments().getList();
        // удаляем первый отдел
        int index = 1;
        app.departments().delete(index);
        app.confirmDialog().confirm();
        assertTrue(app.department().alertSuccess(), "Не появился алерт об успешном удалении отдела.");
        app.departments().waitListUpdated(count, 1);
        int actualCount = app.departments().count();
        assertEquals(actualCount, count-1, "После удаления отдела количество отделов в списке не уменьшилось на 1.");
        before.remove(index - 1);
        // обновленный список отделов
        List<DepartmentData> after = app.departments().getList();
        assertEquals(new HashSet<>(after), new HashSet<>(before),  "Отличаются ожидаемый и полученный список отделов после удаления отдела.");

    }

    /*@Test(priority=7)
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
        app.role().closeAlert();
        app.roles().waitListUpdated(count, 2);
        // удаляем созданную роль
        app.roles().delete(role);
        app.confirmDialog().confirm();
        assertTrue(app.role().alertSuccess(), "Не появился алерт об успешном удалении роли.");
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
        int rowIndex = 1;
        int cellIndex = 1;

        app.settings().goToTimesheets();
        app.timesheets().waitListUpdated(0, 2);

        String value = app.timesheets().getValueFromTheCell(rowIndex, cellIndex);

        // если в ячейке указано время, то флаг дня будет сниматься
        // и время устанавливать не нужно
        if (!value.equals("-")) {
            timeAt = -1;
            timeTo = -1;
            expectedValue = "-";
        }

        app.timesheet().editTimesheet(rowIndex, cellIndex, timeAt, timeTo);
        assertTrue(app.timesheet().alertSuccess(), "Не появился аллерт об успешном обновлении общего расписания.");

        String actualValue = app.timesheets().getValueFromTheCell(rowIndex, cellIndex);
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
        app.user().closeAlert();
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

    @Test(priority=12)
    public void testUserTimesheetEditing() {

        app.settings().goToTimesheets();
        app.timesheets().waitListUpdated(0, 2);
        // если в списке только Общее расписание,
        // создадим новое расписание пользователя
        if (app.timesheets().count()==1) {
            app.settings().goToUsers();
            UserData user = new UserData().withLastName("#auto LastName" + new Random().nextInt(100000))
                    .withFirstName("#auto FirstName" + new Random().nextInt(100000))
                    .withEmail(System.currentTimeMillis() + "@yandex.ru")
                    .withPassword("1");
            app.user().create(user);
            app.user().closeAlert();
            app.settings().goToTimesheets();
            int count = app.timesheets().count();
            app.timesheet().create(user);
            app.timesheet().closeAlert();
            app.timesheets().waitListUpdated(count, 2);
        }

        // сейчас реализован только выбор целых часов
        int timeAt = 13;
        int timeTo = 21;
        String expectedValue = "13:00 — 20:59";
        int rowIndex = 2;
        int cellIndex = 1;

        String value = app.timesheets().getValueFromTheCell(rowIndex, cellIndex);
        System.out.println(value);
        // если в ячейке указано время, то флаг дня будет сниматься
        // и время устанавливать не нужно
       if (!value.equals("-")) {
            timeAt = -1;
            timeTo = -1;
            expectedValue = "-";
        }

        app.timesheet().editTimesheet(rowIndex, cellIndex, timeAt, timeTo);
        assertTrue(app.timesheet().alertSuccess(), "Не появился аллерт об успешном обновлении расписания пользователя.");

        String actualValue = app.timesheets().getValueFromTheCell(rowIndex, cellIndex);
        assertEquals(actualValue, expectedValue, "Для расписания пользователя не верно отображается обновленное время в ячейке");

    }

    @Test(priority=13)
    public void testUserTimesheetDeletion() {

        app.settings().goToTimesheets();
        app.timesheets().waitListUpdated(0, 2);
        // если в списке только Общее расписание,
        // создадим новое расписание пользователя
        if (app.timesheets().count()==1) {
            app.settings().goToUsers();
            UserData user = new UserData().withLastName("#auto LastName" + new Random().nextInt(100000))
                    .withFirstName("#auto FirstName" + new Random().nextInt(100000))
                    .withEmail(System.currentTimeMillis() + "@yandex.ru")
                    .withPassword("1");
            app.user().create(user);
            app.user().closeAlert();
            app.settings().goToTimesheets();
            int count = app.timesheets().count();
            app.timesheet().create(user);
            app.timesheet().closeAlert();
            app.timesheets().waitListUpdated(count, 2);
        }

        int count = app.timesheets().count();
        List<TimesheetData> before = app.timesheets().getList();
        int index = 2;
        app.timesheets().delete(index);
        app.confirmDialog().confirm();
        assertTrue(app.timesheet().alertSuccess(), "Не появился аллерт об успешном удалении расписания пользователя.");
        app.timesheets().waitListUpdated(count, 1);
        int actualCount = app.timesheets().count();
        assertEquals(actualCount, count-1, "После удаления расписания пользователя количество расписаний в списке не уменьшилось на 1.");
        before.remove(index - 1);
        List<TimesheetData> after = app.timesheets().getList();
        assertEquals(new HashSet<>(after), new HashSet<>(before),  "Отличаются ожидаемый и полученный список расписаний пользователей после удаления расписания.");

    }

    @Test(priority=14)
    public void ConnectionLogTest(){

        // текущий день, за который будем смотреть журнал входа (чтобы точно были записи входа)
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DATE);
        calendar.set(year, month, day, 0, 0, 0);
        String startDate = formatForDateNow.format(calendar.getTime());
        calendar.set(year, month, day, 23, 59, 59);
        String endDate = formatForDateNow.format(calendar.getTime());

        app.settings().goToConnectionLog();
        app.connectionLog().filter(startDate, endDate);
        assertTrue(app.connectionLog().isNotEmpty(), "Пустой журнал входа.");
    }

    @Test(priority=15)
    public void testFeedbackTemplateCreation() throws Exception {
        // если для выбора в шаблоне опроса нет ни одной активной причины закрытия,
        // то создаем новую причину закрытия
        if (app.settingsHelper().getActiveСloseReasonsCount() == 0) {
            app.settings().goToСloseReasons();
            app.closeReason().create(new CloseReasonData()
                    .withName("#auto CloseReason " + System.currentTimeMillis())
                    .withSatisfaction(15));
            app.closeReason().closeAlert();
        }
        app.settings().goToFeedbackTemplates();
        int count = 0;
        if (app.settingsHelper().getActiveFeedbackTemplatesCount() != 0){
            app.feedbackTemplates().waitListUpdated(0, 2);
            count = app.feedbackTemplates().count();
        }
        List<FeedbackTemplateData> before = app.feedbackTemplates().getList();
        FeedbackTemplateData newFeedbackTemplate = new FeedbackTemplateData()
                .withName("#auto Feedback " + System.currentTimeMillis())
                .withText("Прошу оценить результат:\n" + "{close_reasons}")
                .withReasonText("Отлично");
        app.feedbackTemplate().create(newFeedbackTemplate);
        assertTrue(app.feedbackTemplate().alertSuccess(), "Не появился алерт об успешном создании шаблона опроса.");
        app.feedbackTemplates().waitListUpdated(count, 2);
        int actualCount = app.feedbackTemplates().count();
        assertEquals(actualCount, count+1, "После создания нового шаблона опроса количество шаблонов в списке не увеличилось на 1.");
        before.add(newFeedbackTemplate);
        List<FeedbackTemplateData> after = app.feedbackTemplates().getList();
        assertEquals(new HashSet<>(after), new HashSet<>(before),  "Отличаются ожидаемый и полученный список шаблонов опросов после добавления нового шпблона.");

    }

    @Test(priority=16)
    public void testFeedbackTemplateEditing() throws Exception {

        // если список швблонов опросов пустой - создаем новый, который будем далее редактировать
        if (app.settingsHelper().getActiveFeedbackTemplatesCount() == 0)
        {
            // если для выбора в шаблоне опроса нет ни одной активной причины закрытия,
            // то создаем новую причину закрытия
            if (app.settingsHelper().getActiveСloseReasonsCount() == 0) {
                app.settings().goToСloseReasons();
                app.closeReason().create(new CloseReasonData()
                        .withName("#auto CloseReason " + System.currentTimeMillis())
                        .withSatisfaction(15));
                app.closeReason().closeAlert();
            }
            app.settings().goToFeedbackTemplates();
            app.feedbackTemplate().create(new FeedbackTemplateData()
                    .withName("#auto Feedback " + System.currentTimeMillis())
                    .withText("Прошу оценить результат:\n" + "{close_reasons}")
                    .withReasonText("Отлично"));
            app.feedbackTemplate().closeAlert();
        }
        else {
            app.settings().goToFeedbackTemplates();
        }

        app.feedbackTemplates().waitListUpdated(0,2);
        List<FeedbackTemplateData> before = app.feedbackTemplates().getList();
        int index = 1;
        FeedbackTemplateData updFeedbackTemplate = new FeedbackTemplateData().withName("#auto Feedback " + System.currentTimeMillis());
        app.feedbackTemplate().edit(index, updFeedbackTemplate);
        assertTrue(app.feedbackTemplate().alertSuccess(), "Не появился алерт об успешном обновлении шаблона опроса.");
        before.remove(index - 1);
        // если был отдерактирован шаблон опроса по умолчанию - добавляем к названию текст (По умолчанию)
        if (app.feedbackTemplates().isDefaultFeedbackTemplate(index))
            before.add(new FeedbackTemplateData().withName(updFeedbackTemplate.getTemplateName() + " (По умолчанию)"));
        else
            before.add(updFeedbackTemplate);

        List<FeedbackTemplateData> after = app.feedbackTemplates().getList();
        assertEquals(new HashSet<>(after), new HashSet<>(before),  "В списке шаблонов опросов не отображается обновленное имя шаблона");
    }

    @Test(priority=17)
    public void testFeedbackTemplateDeletion() throws Exception {

        int activeCount = app.settingsHelper().getActiveFeedbackTemplatesCount();
        int defaultCount = app.settingsHelper().getDefaultFeedbackTemplatesCount();
        // если список швблонов опросов пустой ИЛИ в списке только шаблон по умолчанию (его удалить нельзя)
        // создаем новый шаблон, который будем далее удалять
        if (( activeCount == 0) || (activeCount == defaultCount))
        {
            // если для выбора в шаблоне опроса нет ни одной активной причины закрытия,
            // то создаем новую причину закрытия
            if (app.settingsHelper().getActiveСloseReasonsCount() == 0) {
                app.settings().goToСloseReasons();
                app.closeReason().create(new CloseReasonData()
                        .withName("#auto CloseReason " + System.currentTimeMillis())
                        .withSatisfaction(15));
                app.closeReason().closeAlert();
            }
            app.settings().goToFeedbackTemplates();
            app.feedbackTemplate().create(new FeedbackTemplateData()
                    .withName("#auto Feedback " + System.currentTimeMillis())
                    .withText("Прошу оценить результат:\n" + "{close_reasons}")
                    .withReasonText("Отлично"));
            app.feedbackTemplate().closeAlert();

            if (activeCount == 0)
                app.feedbackTemplates().waitListUpdated(0,2);
            else
                app.feedbackTemplates().waitListUpdated(1,2);

        }
        else {
            app.settings().goToFeedbackTemplates();
            app.feedbackTemplates().waitListUpdated(0,2);
        }

        // получаем индекс первого не default шаблона опроса, так как шаблон опроса по умолчанию нельзя удалить
        int index = app.feedbackTemplates().getNotDefaultFeedbackTemplateIndex();
        Assert.assertTrue(index > 0, "Не найден шаблон опроса для удаления.");
        int count = app.feedbackTemplates().count();
        List<FeedbackTemplateData> before = app.feedbackTemplates().getList();
        app.feedbackTemplates().delete(index);
        app.confirmDialog().confirm();
        assertTrue(app.feedbackTemplate().alertSuccess(), "Не появился алерт об успешном удалении шаблона опроса.");
        app.feedbackTemplates().waitListUpdated(count, 1);
        int actualCount = app.feedbackTemplates().count();
        assertEquals(actualCount, count-1, "После удаления шаблона опроса количество шаблонов в списке не уменьшилось на 1.");
        before.remove(index - 1);
        List<FeedbackTemplateData> after = app.feedbackTemplates().getList();
        assertEquals(new HashSet<>(after), new HashSet<>(before),  "Отличаются ожидаемый и полученный список шаблонов опросов после удаления шпблона.");
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

*/




}
