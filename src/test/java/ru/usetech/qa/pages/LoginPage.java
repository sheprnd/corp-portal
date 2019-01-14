package ru.usetech.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

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

  @FindBy(css=".btn")
  private WebElement submit;

  @FindBy(css=".header__logo2_right-text")
  private WebElement logo;

  public void open(String log,String pswd){
    driver.get("https://mlgext.usetech.ru/");
    login.clear();
    login.sendKeys(log);
    password.clear();
    password.sendKeys(pswd);
    submit.click();
    wait.until(visibilityOf(logo));
  }

}
