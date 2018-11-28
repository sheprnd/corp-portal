package ru.usetech.qa.tests;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class UserCreationTest extends TestBase {

  @Test
  private void goToUsersPage() throws Exception {
    app.login("vm_user02@mail.ru", "12345");
    TimeUnit.SECONDS.sleep(2);
    app.getNavigationHelper().goToSettings();
    TimeUnit.SECONDS.sleep(2);
    app.openCreationUserForm();
    TimeUnit.SECONDS.sleep(2);
    app.newUserFormSubmission();
  }
}
