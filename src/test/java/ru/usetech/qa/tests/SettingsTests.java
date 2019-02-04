package ru.usetech.qa.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.usetech.qa.model.DepartmentData;
import ru.usetech.qa.model.FeedbackTemplateData;
import ru.usetech.qa.model.RoleData;
import ru.usetech.qa.model.UserData;

import java.util.Random;
import java.util.UUID;

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
        app.users().alertSuccess();
    }

    @Test(priority=2)
    public void testRoleCreation() {


        app.settings().goToRoles();
        app.roles().create(new RoleData().withRoleName("#auto Role" + UUID.randomUUID().toString()));
    }

    @Test(priority=3)
    public void testDepartmentCreation() {

        app.settings().goToDepartments();
        app.departmentsPage().create(new DepartmentData().withDepartmentName("#auto Department " + UUID.randomUUID().toString()));
    }

    @Test(priority=4)
    public void testFeedbackTemplateCreation() {

        app.settings().goToFeedbacktemplates();
        app.feedbackTemplatePage().create(new FeedbackTemplateData()
                .withFeedbackTemplateName("#auto Feedback " + UUID.randomUUID().toString())
                .withFeedbackTemplateText("Прошу оценить результат:\n" + "{close_reasons}")
                .withReasonText("Отлично"));

    }
}
