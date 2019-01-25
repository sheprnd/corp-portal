package ru.usetech.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.openqa.selenium.support.ui.ExpectedConditions.stalenessOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class LoginPage extends Page {

    public LoginPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);

    }

  @FindBy(name = "login")
  private WebElement login;

  @FindBy(name = "password")
  private WebElement password;

  @FindBy(css=".login-box .btn:not([disabled])")
  private WebElement submit;

  public void open(String baseUrl){
    driver.get(baseUrl);
  }

  public void login(String log, String pswd) {

    type(login, log);
    type(password, pswd);

    wait.until(visibilityOf(submit));

    click(submit);
    wait.until(stalenessOf(driver.findElement(By.cssSelector(".login-wrap"))));

  }



}
