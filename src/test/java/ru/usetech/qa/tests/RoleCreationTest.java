package ru.usetech.qa.tests;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
public class RoleCreationTest extends TestBase {


  @Test
  private void createNewRole() throws Exception {
    app.login("vm_user02@mail.ru", "12345");
    TimeUnit.SECONDS.sleep(5);
    app.goToSettings();
    TimeUnit.SECONDS.sleep(5);
    app.getRolesHelper().openCreationRoleForm();
    TimeUnit.SECONDS.sleep(5);
    app.getRolesHelper().newRoleFormSubmission();
  }

}
