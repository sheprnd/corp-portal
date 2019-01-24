package ru.usetech.qa.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import ru.usetech.qa.appmanager.ApplicationManager;

import java.io.IOException;

public class TestBase {

    protected static final ApplicationManager app = new ApplicationManager(BrowserType.CHROME);

    @BeforeSuite
    public void setUp() throws IOException {
        app.init();
    }

    @AfterSuite
    public void tearDown() {
        app.stop();

    }

    /*@BeforeMethod
    public void ensureLogin() {

        if (app.isLogOut()) {
            app.loginPage().login(app.getProperty("login"), app.getProperty("password"));

        }

    }*/



}
