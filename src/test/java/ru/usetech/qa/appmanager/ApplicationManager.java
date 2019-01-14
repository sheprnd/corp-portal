package ru.usetech.qa.appmanager;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import ru.usetech.qa.pages.LoginPage;
import ru.usetech.qa.pages.ManualIncPage;
import ru.usetech.qa.pages.NavigationPage;
import ru.usetech.qa.pages.settings.RolesPage;
import ru.usetech.qa.pages.settings.SettingsMainPage;
import ru.usetech.qa.pages.settings.UsersPage;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {

  private LoginPage loginPage;
  private SettingsMainPage settingsMainPage;
  private NavigationPage navigationPage;
  private UsersPage usersPage;
  private RolesPage rolesPage;
  private ManualIncPage manualincPage;

  public ApplicationManager(WebDriver driver){

    loginPage = new LoginPage(driver);
    navigationPage = new NavigationPage(driver);
    settingsMainPage = new SettingsMainPage(driver);
    usersPage = new UsersPage (driver);
    rolesPage = new RolesPage(driver);
    manualincPage = new ManualIncPage(driver);
  }

  public void login(){
    loginPage.open("vm_user02@mail.ru", "12345");

  }
  public void createManInc(){
    manualincPage.CreateManInc();

  }



  /*public WebDriver driver;

  private NavigationHelper navigationHelper;
  private RolesHelper rolesHelper;
  private SessionHelper sessionHelper;


  public void init() {
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    driver.get("https://mlgext.usetech.ru/#/login");
    rolesHelper = new RolesHelper(driver);
    navigationHelper = new NavigationHelper(driver);
    sessionHelper = new SessionHelper(driver);
    sessionHelper.login("vm_user02@mail.ru", "12345");
  }

  public void scrollPage(int start, int finish) {
    JavascriptExecutor jse = (JavascriptExecutor) driver;
    jse.executeScript("scroll(" + start + ", " + finish + ")");
  }

  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  public void selectLocation() throws InterruptedException {
    scrollPage(250, 0);

    WebElement locationSelectorOpen = driver.findElement(By.cssSelector("label.ng-tns-c0-8"));
    locationSelectorOpen.click();

    WebElement searchField = driver.findElement(By.cssSelector("ul.ui-dropdown-items"));
    searchField.click();
  }

  public void enterAnswerContent(String answercontent) {
    driver.findElement(By.cssSelector(".textarea")).sendKeys(Keys.RETURN);
    driver.findElement(By.cssSelector(".textarea")).sendKeys(answercontent);
  }

  public void enterPostUrl(String posturl) {
    long suffix = System.currentTimeMillis() / 1000L;
    driver.findElement(By.cssSelector("input.ng-invalid")).sendKeys(Keys.RETURN);
    driver.findElement(By.cssSelector("input.ng-invalid")).sendKeys(posturl + suffix);

  }


  public void openCreationUserForm() {
    WebElement settingsButton = driver.findElement(By.cssSelector("div.content__filtr_btn > button.btn.btn-left"));
    Actions action = new Actions(driver);
    action.moveToElement(settingsButton).click().perform();
  }

  public void newUserFormSubmission() {
    UUID randomidraw = UUID.randomUUID();
    String randomid = randomidraw.toString().substring(2, 6);
    //Enter user first name
    driver.findElement(By.cssSelector("input[name= 'firstName']")).sendKeys("Gomer" + randomid);
    //Enter user last name
    driver.findElement(By.cssSelector("input[name= 'lastName']")).sendKeys("Simpson" + randomid);
    //Enter user email
    driver.findElement(By.cssSelector("input[name= 'email']")).sendKeys("Gomer" + randomid + "@mail.ru");
    //Enter user password, repeat password
    driver.findElement(By.cssSelector("input[name = 'pass1']")).sendKeys("passwd" + randomid);
    driver.findElement(By.cssSelector("input[name = 'pass2']")).sendKeys("passwd" + randomid);

    rolesHelper.scrollPage(250, 0);
    //select checkbox for role
    driver.findElement(By.cssSelector("div:nth-child(4) > p-checkbox > label")).click();
    driver.findElement(By.cssSelector("div.modal-footer > button.btn.btn-left.btn__blue")).click();
  }


  public void stop() {
    driver.quit();
  }

  public RolesHelper getRolesHelper() {
    return rolesHelper;
  }

  public NavigationHelper getNavigationHelper() {
    return navigationHelper;
  }*/
}
