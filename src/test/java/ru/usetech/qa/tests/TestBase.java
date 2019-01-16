package ru.usetech.qa.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import ru.usetech.qa.appmanager.ApplicationManager;

public class TestBase {

    protected static final ApplicationManager app = new ApplicationManager();

    @BeforeSuite
    public void setUp() {
        app.init();
    }

    @AfterSuite
    public void tearDown() {
        app.stop();

    }

    @BeforeMethod
    public void ensureLogin() {

    }

   /* private WebDriver driver;
    public ApplicationManager app;

    @BeforeClass
    public void start() {
        if (driver != null) {
            return;
        }
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        app = new ApplicationManager(driver);


    }

    @AfterClass
    public void stop() {
        driver.quit();
        driver = null;
    }
*/


}
