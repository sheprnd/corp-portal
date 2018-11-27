package ru.usetech.tests;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class RoleCreationTest extends TestBase{



  @Test
  private void createNewRole() throws Exception {
    login("vm_user02@mail.ru", "12345");
    TimeUnit.SECONDS.sleep(5);
    goToSettings();
    TimeUnit.SECONDS.sleep(5);
    openCreationRoleForm();
    TimeUnit.SECONDS.sleep(5);
    newRoleFormSubmission();
  }

}
