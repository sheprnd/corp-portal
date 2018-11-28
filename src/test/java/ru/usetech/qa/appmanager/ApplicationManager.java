package ru.usetech.qa.appmanager;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {

  private final RolesHelper rolesHelper = new RolesHelper();

  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  public void pressCreateBtn() {
    rolesHelper.driver.findElement(By.cssSelector("div.modal-footer > button.btn__blue")).click();
  }

  public void selectLocation() throws InterruptedException {
    rolesHelper.scrollPage(250, 0);

    WebElement locationSelectorOpen = rolesHelper.driver.findElement(By.cssSelector("label.ng-tns-c0-8"));
    locationSelectorOpen.click();

    WebElement searchField = rolesHelper.driver.findElement(By.cssSelector("ul.ui-dropdown-items"));
    searchField.click();
    System.out.println("Location has been added");
  }

  public void enterAnswerContent(String answercontent) {
    rolesHelper.driver.findElement(By.cssSelector(".textarea")).sendKeys(Keys.RETURN);
    rolesHelper.driver.findElement(By.cssSelector(".textarea")).sendKeys(answercontent);
    System.out.println("Answer text has been inputed");
  }

  public void enterPostUrl(String posturl) {
    long suffix = System.currentTimeMillis() / 1000L;
    rolesHelper.driver.findElement(By.cssSelector("input.ng-invalid")).sendKeys(Keys.RETURN);
    rolesHelper.driver.findElement(By.cssSelector("input.ng-invalid")).sendKeys(posturl + suffix);
    System.out.println("Post url has been added");

  }

  public void openModal() throws InterruptedException {
    if (rolesHelper.driver.findElement(By.cssSelector(".btn-big")).isDisplayed()) {
      rolesHelper.driver.findElement(By.cssSelector(".btn-big")).sendKeys(Keys.RETURN);
      System.out.println("Modal opened");

    } else {
      System.out.println("Modal has not been opened");
    }
  }

  public void login(String username, String password) {
    rolesHelper.driver.findElement(By.name("login")).clear();
    rolesHelper.driver.findElement(By.name("login")).sendKeys(username);
    rolesHelper.driver.findElement(By.name("password")).clear();
    rolesHelper.driver.findElement(By.name("password")).sendKeys(password);
    rolesHelper.driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Загрузка параметров'])[1]/preceding::button[1]")).click();
  }

  public void goToSettings() {
    WebElement settingsButton = rolesHelper.driver.findElement(By.cssSelector("a.left-menu__link[href*='settings']"));
    Actions action = new Actions(rolesHelper.driver);
    action.moveToElement(settingsButton).click().perform();
  }

  public void openCreationUserForm() {
    WebElement settingsButton = rolesHelper.driver.findElement(By.cssSelector("div.content__filtr_btn > button.btn.btn-left"));
    Actions action = new Actions(rolesHelper.driver);
    action.moveToElement(settingsButton).click().perform();
  }

  public void newUserFormSubmission() {
    UUID randomidraw = UUID.randomUUID();
    String randomid = randomidraw.toString().substring(2, 6);
    //Enter user first name
    rolesHelper.driver.findElement(By.cssSelector("input[name= 'firstName']")).sendKeys("Gomer" + randomid);
    //Enter user last name
    rolesHelper.driver.findElement(By.cssSelector("input[name= 'lastName']")).sendKeys("Simpson" + randomid);
    //Enter user email
    rolesHelper.driver.findElement(By.cssSelector("input[name= 'email']")).sendKeys("Gomer" + randomid + "@mail.ru");
    //Enter user password, repeat password
    rolesHelper.driver.findElement(By.cssSelector("input[name = 'pass1']")).sendKeys("passwd" + randomid);
    rolesHelper.driver.findElement(By.cssSelector("input[name = 'pass2']")).sendKeys("passwd" + randomid);

    rolesHelper.scrollPage(250, 0);
    //select checkbox for role
    rolesHelper.driver.findElement(By.cssSelector("div:nth-child(4) > p-checkbox > label")).click();
    rolesHelper.driver.findElement(By.cssSelector("div.modal-footer > button.btn.btn-left.btn__blue")).click();
  }

  public void init() {
    rolesHelper.driver = new ChromeDriver();
    rolesHelper.driver.manage().window().maximize();
    rolesHelper.driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    rolesHelper.driver.get("https://mlgext.usetech.ru/#/login");
  }

  public void stop() {
    rolesHelper.driver.quit();
  }

  public RolesHelper getRolesHelper() {
    return rolesHelper;
  }
}
