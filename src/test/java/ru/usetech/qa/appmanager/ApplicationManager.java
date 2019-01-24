package ru.usetech.qa.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import ru.usetech.qa.pages.LoginPage;
import ru.usetech.qa.pages.ManualIncPage;
import ru.usetech.qa.pages.NavigationMenu;
import ru.usetech.qa.pages.settings.SettingsMenu;
import ru.usetech.qa.pages.settings.UsersPage;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ApplicationManager {

    WebDriver driver;
    private final Properties properties;

    private LoginPage loginPage;
    private SettingsMenu settingsMenu;
    private NavigationMenu navigationMenu;
    private UsersPage usersPage;
    private ManualIncPage manualincPage;
    private String browser;

    public ApplicationManager(String browser) {
        this.browser = browser;
        properties = new Properties();
    }

    public void init() throws IOException {

        properties.load(new FileReader(new File(String.format("src/test/resources/local.properties"))));

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");

        if (browser.equals(BrowserType.CHROME)) {
            driver = new ChromeDriver(options);
        } else if (browser.equals(BrowserType.FIREFOX)) {
            driver = new FirefoxDriver(); // погуглить как запускать с опциями
        }

        loginPage = new LoginPage(driver);
        navigationMenu = new NavigationMenu(driver);
        settingsMenu = new SettingsMenu(driver);
        usersPage = new UsersPage(driver);
        manualincPage = new ManualIncPage(driver);

        loginPage.open(getProperty("baseUrl"));
        loginPage.login(getProperty("login"), getProperty("password"));
    }

    public LoginPage loginPage() {
        return loginPage;
    }

    public SettingsMenu settings() {
        return settingsMenu;
    }

    public NavigationMenu goTo() {
        return navigationMenu;
    }

    public UsersPage users() {
        return usersPage;
    }

    public ManualIncPage manualInc() {
        return manualincPage;
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

  /*public boolean isLogOut() {

    if (driver.getCurrentUrl().equals(getProperty("baseUrl"))) {
      //System.out.println(driver.getCurrentUrl());
      return true;
    } else {
      return false;
    }
  }*/

    public void stop() {
        driver.quit();
    }


}
