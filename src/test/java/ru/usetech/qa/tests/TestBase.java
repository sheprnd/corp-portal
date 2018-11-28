package ru.usetech.qa.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import ru.usetech.qa.appmanager.ApplicationManager;

public class TestBase {

  protected final ApplicationManager app = new ApplicationManager();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    app.init();
  }

  @AfterClass
  public void tearDown() {
    app.stop();

  }

}
