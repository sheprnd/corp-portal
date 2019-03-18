package ru.usetech.qa.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import ru.usetech.qa.pages.LoginPage;
import ru.usetech.qa.pages.ManualIncPage;
import ru.usetech.qa.pages.NavigationMenu;
import ru.usetech.qa.pages.modalDialogs.AddDeleteReasonDialog;
import ru.usetech.qa.pages.settings.*;
import ru.usetech.qa.pages.stages.IncidentsListPage;
import ru.usetech.qa.pages.stages.PipelineMenu;
import ru.usetech.qa.pages.stages.PostsListPage;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ApplicationManager {

    WebDriver driver;
    private final Properties properties;

    private LoginPage loginPage;
    private SettingsMenu settingsMenu;
    private PostsListPage postsListPage;
    private NavigationMenu navigationMenu;
    private UsersPage usersPage;
    private ManualIncPage manualincPage;
    private String browser;
    private RolesPage rolesPage;
    private DepartmentsPage departmentsPage;
    private FeedbackTemplatePage feedbackTemplatePage;
    private IncidentsListPage incidentsListPage;
    private PipelineMenu pipelineMenu;
    private ClientReferencePage clientReferencePage;
    private WorkflowPage workflowPage;
    private PostsHelper postsHelper;
    private SettingsHelper settingsHelper;
    private AddDeleteReasonDialog addDeleteReasonDialog;

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
        postsListPage = new PostsListPage(driver);
        navigationMenu = new NavigationMenu(driver);
        settingsMenu = new SettingsMenu(driver);
        usersPage = new UsersPage(driver);
        manualincPage = new ManualIncPage(driver);
        rolesPage = new RolesPage(driver);
        departmentsPage = new DepartmentsPage(driver);
        feedbackTemplatePage = new FeedbackTemplatePage(driver);
        incidentsListPage = new IncidentsListPage(driver);
        pipelineMenu = new PipelineMenu(driver);
        clientReferencePage = new ClientReferencePage(driver);
        workflowPage = new WorkflowPage(driver);
        postsHelper = new PostsHelper (this);
        settingsHelper = new SettingsHelper (this);
        addDeleteReasonDialog = new AddDeleteReasonDialog(driver);
        loginPage.open(getProperty("baseUrl"));
        loginPage.login(getProperty("login"), getProperty("password"));
    }

    public LoginPage loginPage() { return loginPage; }

    public PostsListPage posts() { return postsListPage; }

    public SettingsMenu settings() { return settingsMenu; }

    public NavigationMenu goTo() { return navigationMenu; }

    public PipelineMenu pipeline() { return pipelineMenu; }

    public IncidentsListPage incidents() { return incidentsListPage; }

    public UsersPage users() { return usersPage; }

    public RolesPage roles() { return rolesPage; }

    public DepartmentsPage departments() { return departmentsPage; }

    public FeedbackTemplatePage feedbackTemplates() { return feedbackTemplatePage; }

    public WorkflowPage workflow() { return workflowPage; }

    public ManualIncPage manualInc() { return manualincPage; }

    public ClientReferencePage clientReferences() { return clientReferencePage; }

    public PostsHelper postsHelper(){
        return postsHelper;
    }

    public SettingsHelper settingsHelper(){
        return settingsHelper;
    }

    public AddDeleteReasonDialog deleteReasonDialog(){
        return addDeleteReasonDialog;
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
