package ru.usetech.qa.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class NavigationHelper {

  private WebDriver driver;

  public NavigationHelper(WebDriver driver) {
    this.driver = driver;
  }


  public void pressCreateBtn() {
    driver.findElement(By.cssSelector("div.modal-footer > button.btn__blue")).click();
  }

  public void openModal() throws InterruptedException {
    if (driver.findElement(By.cssSelector(".btn-big")).isDisplayed()) {
      driver.findElement(By.cssSelector(".btn-big")).sendKeys(Keys.RETURN);
      System.out.println("Modal opened");

    } else {
      System.out.println("Modal has not been opened");
    }
  }

  public void goToSettings() {
    WebElement settingsButton = driver.findElement(By.cssSelector("a.left-menu__link[href*='settings']"));
    Actions action = new Actions(driver);
    action.moveToElement(settingsButton).click().perform();
  }
}
