package ru.usetech.tests;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class UserCreationTest extends TestBase{



  @Test
  private void goToUsersPage() throws Exception {
    login("vm_user02@mail.ru", "12345");
    TimeUnit.SECONDS.sleep(2);
    goToSettings();
    TimeUnit.SECONDS.sleep(2);
    openCreationUserForm();
    TimeUnit.SECONDS.sleep(2);
    newUserFormSubmission();
  }
}
