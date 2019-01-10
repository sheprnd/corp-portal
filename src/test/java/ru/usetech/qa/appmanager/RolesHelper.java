package ru.usetech.qa.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class RolesHelper {
  /*private WebDriver driver;

  public RolesHelper(WebDriver driver) {
    this.driver = driver;
  }

  public void scrollPage(int start, int finish) {
    JavascriptExecutor jse = (JavascriptExecutor) driver;
    jse.executeScript("scroll(" + start + ", " + finish + ")");
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

  }*/
}
