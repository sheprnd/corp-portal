package ru.usetech.tests;

import org.testng.annotations.Test;

public class UserCreationTest extends TestBase{



  @Test
  private void goToUsersPage() throws Exception {
    login("vm_user02@mail.ru", "12345");
    goToSettings();
    openCreationUserForm();
    newUserFormSubmission();

  }
}
