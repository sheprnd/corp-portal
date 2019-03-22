package ru.usetech.qa.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import ru.usetech.qa.appmanager.ApplicationManager;

import java.io.IOException;
@Listeners(MyTestListener.class)
public class TestBase {

    protected static final ApplicationManager app = new ApplicationManager(BrowserType.CHROME);

    @BeforeSuite
    public void setUp(ITestContext context) throws IOException {
        app.init();
        context.setAttribute("app", app);
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
