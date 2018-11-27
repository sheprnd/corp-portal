package ru.usetech.qa.appmanager;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
  public WebDriver driver;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  public void pressCreateBtn() {
    driver.findElement(By.cssSelector("div.modal-footer > button.btn__blue")).click();
  }

  public void selectLocation() throws InterruptedException {
    scrollPage(250, 0);

    WebElement locationSelectorOpen = driver.findElement(By.cssSelector("label.ng-tns-c0-8"));
    locationSelectorOpen.click();

    WebElement searchField = driver.findElement(By.cssSelector("ul.ui-dropdown-items"));
    searchField.click();
    System.out.println("Location has been added");
  }

  private void scrollPage(final int start, final int finish) {
    JavascriptExecutor jse = (JavascriptExecutor) driver;
    jse.executeScript("scroll(" + start + ", " + finish + ")");
  }

  public void enterAnswerContent(String answercontent) {
    driver.findElement(By.cssSelector(".textarea")).sendKeys(Keys.RETURN);
    driver.findElement(By.cssSelector(".textarea")).sendKeys(answercontent);
    System.out.println("Answer text has been inputed");
  }

  public void enterPostUrl(String posturl) {
    long suffix = System.currentTimeMillis() / 1000L;
    driver.findElement(By.cssSelector("input.ng-invalid")).sendKeys(Keys.RETURN);
    driver.findElement(By.cssSelector("input.ng-invalid")).sendKeys(posturl + suffix);
    System.out.println("Post url has been added");

  }

  public void openModal() throws InterruptedException {
    if (driver.findElement(By.cssSelector(".btn-big")).isDisplayed()) {
      driver.findElement(By.cssSelector(".btn-big")).sendKeys(Keys.RETURN);
      System.out.println("Modal opened");

    } else {
      System.out.println("Modal has not been opened");
    }
  }

  public void login(String username, String password) {
    driver.findElement(By.name("login")).clear();
    driver.findElement(By.name("login")).sendKeys(username);
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys(password);
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Загрузка параметров'])[1]/preceding::button[1]")).click();
  }

  public void goToSettings() {
    WebElement settingsButton = driver.findElement(By.cssSelector("a.left-menu__link[href*='settings']"));
    Actions action = new Actions(driver);
    action.moveToElement(settingsButton).click().perform();
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

    scrollPage(250, 0);
    //select checkbox for role
    driver.findElement(By.cssSelector("div:nth-child(4) > p-checkbox > label")).click();
    driver.findElement(By.cssSelector("div.modal-footer > button.btn.btn-left.btn__blue")).click();
  }

  public void openCreationRoleForm() throws InterruptedException {
    driver.findElement(By.cssSelector("a[href= '#/settings/groups']")).click();
    TimeUnit.SECONDS.sleep(5);
    WebElement settingsButton = driver.findElement(By.cssSelector("div.content__filtr_btn > button.btn.btn-left"));
    Actions action = new Actions(driver);
    action.moveToElement(settingsButton).click().perform();

  }

  public void newRoleFormSubmission() {
    UUID randomidraw = UUID.randomUUID();
    String randomid = randomidraw.toString().substring(2, 6);
    //Enter group name
    driver.findElement(By.cssSelector("input[name= 'nameGroup']")).sendKeys("Group" + randomid);
    scrollPage(250, 0);
    //select checkbox for role
    driver.findElement(By.cssSelector("div.modal-footer > button.btn.btn-left.btn__blue")).click();

  }

  public void init() {
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    driver.get("https://mlgext.usetech.ru/#/login");
  }

  public void stop() {
    driver.quit();
  }
}
