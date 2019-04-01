package ru.usetech.qa.appmanager;

import com.sun.jndi.toolkit.url.Uri;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
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
import java.net.URL;
import java.util.List;
import java.util.Properties;

import static org.openqa.selenium.remote.DesiredCapabilities.chrome;

public class ApplicationManager {

    WebDriver driver;
    private final Properties properties;
    private String browser;

    private LoginPage loginPage;
    private NavigationMenu navigationMenu;
    private PipelineMenu pipelineMenu;
    private SettingsMenu settingsMenu;

    private ManualIncPage manualincPage;
    private PostsListPage postsListPage;
    private IncidentsListPage incidentsListPage;

    private UserPage userPage;
    private DepartmentPage departmentPage;
    private RolePage rolePage;
    private TimesheetPage timesheetPage;
    private FeedbackTemplatePage feedbackTemplatePage;
    private WebhookPage webhookPage;
    private WorkflowPage workflowPage;
    private ClientReferencePage clientReferencePage;
    private PriorityPage priorityPage;
    private CategoryPage categoryPage;
    private ReportPage reportPage;
    private ReportGroupPage reportGroupPage;
    private LocationPage locationPage;

    private GeneralList generalList;
    private UsersList usersList;
    private RolesList rolesList;
    private TimesheetsList timesheetsList;
    private WebhooksList webhooksList;
    private ReportGroupsList reportGroupsList;

    private AddDeleteReasonDialog addDeleteReasonDialog;

    private PostsHelper postsHelper;
    private SettingsHelper settingsHelper;

    public ApplicationManager(String browser) {
        this.browser = browser;
        properties = new Properties();
    }

    public void init() throws IOException {

        properties.load(new FileReader(new File(String.format("src/test/resources/local.properties"))));

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        //options.addArguments("--no-sandbox");
        options.addArguments("--headless");
        options.addArguments("--window-size=1920,1080");
        options.setCapability("browserName", "chrome");
        options.setCapability("version ", "73");



        if (browser.equals(BrowserType.CHROME)) {
            //driver =  new RemoteWebDriver(new URL("http://127.0.1.1:4444/wd/hub"), DesiredCapabilities.chrome());
            //driver =  new RemoteWebDriver(new URL("http://94.177.172.202:4444/wd/hub"), DesiredCapabilities.chrome());
            driver =  new RemoteWebDriver(new URL("http://94.177.172.202:4444/wd/hub"), options);
            //driver =  new RemoteWebDriver(new URL("http://127.0.1.1:4444/wd/hub"), options);

        } else if (browser.equals(BrowserType.FIREFOX)) {
            driver = new FirefoxDriver(); // погуглить как запускать с опциями
        }

        loginPage = new LoginPage(driver);
        navigationMenu = new NavigationMenu(driver);
        pipelineMenu = new PipelineMenu(driver);
        settingsMenu = new SettingsMenu(driver);

        manualincPage = new ManualIncPage(driver);
        postsListPage = new PostsListPage(driver);
        incidentsListPage = new IncidentsListPage(driver);

        userPage = new UserPage(driver);
        departmentPage = new DepartmentPage(driver);
        rolePage = new RolePage(driver);
        timesheetPage = new TimesheetPage(driver);
        feedbackTemplatePage = new FeedbackTemplatePage(driver);
        webhookPage = new WebhookPage(driver);
        workflowPage = new WorkflowPage(driver);
        clientReferencePage = new ClientReferencePage(driver);
        priorityPage = new PriorityPage(driver);
        categoryPage = new CategoryPage(driver);
        reportPage = new ReportPage(driver);
        reportGroupPage = new ReportGroupPage(driver);
        locationPage = new LocationPage(driver);

        generalList = new GeneralList(driver);
        usersList = new UsersList(driver);
        rolesList = new RolesList(driver);
        timesheetsList = new TimesheetsList(driver);
        webhooksList = new WebhooksList(driver);
        reportGroupsList = new ReportGroupsList(driver);

        addDeleteReasonDialog = new AddDeleteReasonDialog(driver);

        postsHelper = new PostsHelper (this);
        settingsHelper = new SettingsHelper (this);

        loginPage.open(getProperty("baseUrl"));
        loginPage.login(getProperty("login"), getProperty("password"));
    }

    public LoginPage loginPage() { return loginPage; }
    public NavigationMenu goTo() { return navigationMenu; }
    public PipelineMenu pipeline() { return pipelineMenu; }
    public SettingsMenu settings() { return settingsMenu; }

    public ManualIncPage manualInc() { return manualincPage; }
    public PostsListPage posts() { return postsListPage; }
    public IncidentsListPage incidents() { return incidentsListPage; }

    public UserPage user() { return userPage; }
    public DepartmentPage department() { return departmentPage; }
    public RolePage role() { return rolePage; }
    public TimesheetPage timesheet() {return timesheetPage;}
    public FeedbackTemplatePage feedbackTemplates() { return feedbackTemplatePage; }
    public WebhookPage webhook() {return  webhookPage;}
    public WorkflowPage workflow() { return workflowPage; }
    public ClientReferencePage clientReferences() { return clientReferencePage; }
    public PriorityPage priority() { return priorityPage; }
    public CategoryPage category() { return categoryPage; }
    public ReportPage report() { return reportPage; }
    public ReportGroupPage reportGroup() {
        return reportGroupPage;
    }
    public LocationPage location() {return locationPage;}

    public GeneralList list(){
        return generalList;
    }
    public UsersList users(){return usersList;}
    public RolesList roles(){return rolesList;}
    public TimesheetsList timesheets() {return timesheetsList;}
    public WebhooksList webhooks() {return webhooksList;}
    public ReportGroupsList reportGroups() {
        return reportGroupsList;
    }

    public AddDeleteReasonDialog deleteReasonDialog(){
        return addDeleteReasonDialog;
    }

    public PostsHelper postsHelper(){
        return postsHelper;
    }
    public SettingsHelper settingsHelper(){
        return settingsHelper;
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

    public byte[] takeScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

}
